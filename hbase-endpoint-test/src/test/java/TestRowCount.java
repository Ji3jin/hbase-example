import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.coprocessor.Batch;
import org.apache.hadoop.hbase.ipc.BlockingRpcCallback;
import org.apache.hadoop.hbase.ipc.ServerRpcController;

import com.imooc.bigdata.hbase.coprocessor.endpoint.GetRowCount;
import com.imooc.bigdata.hbase.coprocessor.endpoint.GetRowCount.getRowCountResponse;
import com.imooc.bigdata.hbase.coprocessor.endpoint.GetRowCount.hbaseEndPointTestService;

/**
 * Created by jixin on 18-2-23.
 */
public class TestRowCount {

  public static void main(String[] args) throws Throwable {
    Configuration config = new Configuration();
    config.set("hbase.zookeeper.quorum", "127.0.0.1:2181");

    Table table = null;
    Connection connection = null;

    // 返回值接收，Map<region名称,计算结果>
    Map<byte[], getRowCountResponse> results = null;

    try {
      connection = ConnectionFactory.createConnection(config);
      table = connection.getTable(TableName.valueOf("test_table"));

      // 调用 RPC，并对返回值进行处理。
      Batch.Call<hbaseEndPointTestService, getRowCountResponse> callable = new Batch.Call<hbaseEndPointTestService, getRowCountResponse>() {
        ServerRpcController controller = new ServerRpcController();

        // 定义返回
        BlockingRpcCallback<getRowCountResponse> rpcCallback = new BlockingRpcCallback<getRowCountResponse>();

        // 下面重载 call 方法，API会连接到region后会运行call方法来执行服务的请求
        @Override
        public getRowCountResponse call(hbaseEndPointTestService instance)
            throws IOException {
          // Server 端会进行慢速的遍历 region 的方法进行统计
          GetRowCount.getRowCountRequest.Builder request = GetRowCount.getRowCountRequest
              .newBuilder();
          // RPC 接口方法调用
          instance.getRowCount(controller, request.build(),
              rpcCallback);
          // 直接返回结果，即该 Region 的 计算结果
          return rpcCallback.get();

        }
      };

      /**
       * 通过Table.coprocessorService(Class, byte[], byte[],Batch.Call)
       * 请求多region服务
       *
       * byte[]参数指明了startRowKey和endRowKey，当都为null的时候即进行全表的全region的数据计算。
       * 　　　*　Batch.Call：需要自定义，API会根据如上参数信息并行的连接各个region，
       */
      results = table.coprocessorService(hbaseEndPointTestService.class,
          null, null,
          callable);

      // 合并多个Region的结果
      Collection<getRowCountResponse> resultsc = results.values();
      long result = 0L;
      for (getRowCountResponse r : resultsc) {
        result += r.getRowCount();
      }
      System.out.println(String.format("row count=%s", result));

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != table) {
        try {
          table.close();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }

      if (null != connection) {
        try {
          connection.close();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }

  }
}
