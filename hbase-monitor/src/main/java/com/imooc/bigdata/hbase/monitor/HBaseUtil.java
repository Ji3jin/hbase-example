package com.imooc.bigdata.hbase.monitor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imooc.bigdata.hbase.monitor.entity.HbaseSummary;
import com.imooc.bigdata.hbase.monitor.entity.RegionServerInfo;

/**
 * Created by jixin on 18-3-24.
 */
public class HBaseUtil {

  public static long mbLength = 1048576L;
  public static long gbLength = 1073741824L;
  public static final String jmxServerUrlFormat = "%s/jmx?qry=%s";
  public static final String hbaseRegionJmxUrlFormat = "http://%s:%s/jmx?qry=%s";
  public static final String hbaseJmxServerUrl = "http://localhost:16010";
  public static final String hbaseRegionServerJmxPort = "16301";
  public static final String masterServer = "Hadoop:service=HBase,name=Master,sub=Server";
  public static final String regionServer = "Hadoop:service=HBase,name=RegionServer,sub=Server";
  public static final String regionIpc = "Hadoop:service=HBase,name=RegionServer,sub=IPC";

  public static HbaseSummary getHbaseSummary(StatefulHttpClient client)throws IOException{
    HbaseSummary hbaseSummary = new HbaseSummary();
    String hmasterUrl= String.format(jmxServerUrlFormat,hbaseJmxServerUrl,masterServer);
    MonitorMetrics monitorMetrics = client.get(MonitorMetrics.class,hmasterUrl,null,null);

    hbaseSummary
        .setNumDeadRegionServers((int) monitorMetrics.getMetricsValue("numDeadRegionServers"));
    hbaseSummary.setNumRegionServers((int) monitorMetrics.getMetricsValue("numRegionServers"));
    String liveRegionServers = monitorMetrics.getMetricsValue("tag.liveRegionServers")
        .toString();
    hbaseSummary.setLiveRegionServers(regionServerInfoReader(client, liveRegionServers, true));
    String deadRegionServers = monitorMetrics.getMetricsValue("tag.deadRegionServers")
        .toString();
    hbaseSummary.setDeadRegionServers(regionServerInfoReader(client, deadRegionServers, false));
    hbaseSummary.setHmasterNode("localhost");
    return hbaseSummary;
  }

  public static List<RegionServerInfo> regionServerInfoReader(StatefulHttpClient client,
      String regionServerStr, boolean getInfo) {
    List<RegionServerInfo> regionServerInfos = new ArrayList<>();
    Date nowDate = new Date();
    for (String info : regionServerStr.split(";")) {
      String hostName = info.split(",")[0];
      RegionServerInfo regionServerInfo = new RegionServerInfo();
      if (getInfo) {
        try {
          String regionServerUrl = String
              .format(hbaseRegionJmxUrlFormat, hostName,
                  hbaseRegionServerJmxPort, regionServer);
          MonitorMetrics hadoopMetrics = client
              .get(MonitorMetrics.class, regionServerUrl, null, null);
          regionServerInfo.setHostName(hostName);
          regionServerInfo.setStoreCount((int) hadoopMetrics.getMetricsValue("storeCount"));
          regionServerInfo.setRegionCount((int) hadoopMetrics.getMetricsValue("regionCount"));
          regionServerInfo.setStoreFileCount((int) hadoopMetrics.getMetricsValue("storeFileCount"));
          regionServerInfo.setMemStoreSize(
              (int) hadoopMetrics.getMetricsValue("memStoreSize") / mbLength);
          regionServerInfo.setStoreFileSize(
              doubleFormat(hadoopMetrics.getMetricsValue("storeFileSize"),
                  gbLength));
          regionServerInfo
              .setStaticIndexSize((int) hadoopMetrics.getMetricsValue("staticIndexSize"));
          regionServerInfo
              .setTotalRequestCount((int) hadoopMetrics.getMetricsValue("totalRequestCount"));
          regionServerInfo
              .setReadRequestCount((int) hadoopMetrics.getMetricsValue("readRequestCount"));
          regionServerInfo
              .setWriteRequestCount((int) hadoopMetrics.getMetricsValue("writeRequestCount"));
          regionServerInfo
              .setCompactedCellsCount((int) hadoopMetrics.getMetricsValue("compactedCellsCount"));
          regionServerInfo.setMajorCompactedCellsCount(
              (int) hadoopMetrics.getMetricsValue("majorCompactedCellsCount"));
          regionServerInfo.setFlushedCellsSize(
              doubleFormat(hadoopMetrics.getMetricsValue("flushedCellsSize"),
                  gbLength));
          regionServerInfo
              .setBlockedRequestCount((int) hadoopMetrics.getMetricsValue("blockedRequestCount"));
          regionServerInfo
              .setSplitRequestCount((int) hadoopMetrics.getMetricsValue("splitRequestCount"));
          regionServerInfo
              .setSplitSuccessCount((int) hadoopMetrics.getMetricsValue("splitSuccessCount"));
          regionServerInfo.setSlowGetCount((int) hadoopMetrics.getMetricsValue("slowGetCount"));
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          String regionIpcUrl = String
              .format(hbaseRegionJmxUrlFormat, hostName,
                  hbaseRegionServerJmxPort, regionIpc);
          MonitorMetrics hadoopMetrics = client
              .get(MonitorMetrics.class, regionIpcUrl, null, null);
          regionServerInfo
              .setNumOpenConnections((int) hadoopMetrics.getMetricsValue("numOpenConnections"));
          regionServerInfo
              .setNumActiveHandler((int) hadoopMetrics.getMetricsValue("numActiveHandler"));
          regionServerInfo.setSentBytes(
              doubleFormat(hadoopMetrics.getMetricsValue("sentBytes"), gbLength));
          regionServerInfo.setReceivedBytes(
              doubleFormat(hadoopMetrics.getMetricsValue("receivedBytes"),
                  gbLength));
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        regionServerInfo = new RegionServerInfo();
        regionServerInfo.setHostName(hostName);
      }
      regionServerInfos.add(regionServerInfo);
    }
    return regionServerInfos;
  }





  public static DecimalFormat df = new DecimalFormat("#.##");

  public static double doubleFormat(Object num, long unit) {
    double result = Double.parseDouble(String.valueOf(num)) / unit;
    return Double.parseDouble(df.format(result));
  }

  public static double doubleFormat(Object num) {
    double result = Double.parseDouble(String.valueOf(num));
    return Double.parseDouble(df.format(result));
  }
}
