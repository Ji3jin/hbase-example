package com.imooc.bigdata.hbase.monitor;

import java.io.IOException;

/**
 * Created by jixin on 18-3-24.
 */
public class MonitorApp {

  public static void main(String[] args) throws IOException {
    StatefulHttpClient client = new StatefulHttpClient(null);
    HadoopUtil.getHdfsSummary(client).printInfo();
    HBaseUtil.getHbaseSummary(client).printInfo();
  }
}
