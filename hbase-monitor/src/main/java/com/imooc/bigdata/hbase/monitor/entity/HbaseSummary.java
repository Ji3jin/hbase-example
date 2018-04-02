package com.imooc.bigdata.hbase.monitor.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by jixin on 18-3-24.
 */
public class HbaseSummary {

  //"name": "Hadoop:service=HBase,name=Master,sub=Server"
  private String hmasterNode;
  private String status;
  //处于可用状态的regionserver汇总
  private List<RegionServerInfo> liveRegionServers;
  //处于不可用状态的regionserver汇总
  private List<RegionServerInfo> deadRegionServers;
  //处于可用状态的regionserver数量
  private int numRegionServers;
  //处于不可用状态的regionserver数量
  private int numDeadRegionServers;
  private Date createTime;

  public void printInfo() {
    System.out.println("HBASE SUMMARY INFO");
    System.out.println(String
        .format("numRegionServers:%d\nnumDeadRegionServers%d\n", numRegionServers,
            numDeadRegionServers));
    liveRegionServers.forEach(regionServerInfo -> {
      System.out.println(String
          .format("hostName:%s\nregionCount:%s", regionServerInfo.getHostName(),
              regionServerInfo.getRegionCount()));

    });
    System.out.println("----------------------");

  }

  public String getHmasterNode() {
    return hmasterNode;
  }

  public void setHmasterNode(String hmasterNode) {
    this.hmasterNode = hmasterNode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<RegionServerInfo> getLiveRegionServers() {
    return liveRegionServers;
  }

  public void setLiveRegionServers(
      List<RegionServerInfo> liveRegionServers) {
    this.liveRegionServers = liveRegionServers;
  }

  public List<RegionServerInfo> getDeadRegionServers() {
    return deadRegionServers;
  }

  public void setDeadRegionServers(
      List<RegionServerInfo> deadRegionServers) {
    this.deadRegionServers = deadRegionServers;
  }

  public int getNumRegionServers() {
    return numRegionServers;
  }

  public void setNumRegionServers(int numRegionServers) {
    this.numRegionServers = numRegionServers;
  }

  public int getNumDeadRegionServers() {
    return numDeadRegionServers;
  }

  public void setNumDeadRegionServers(int numDeadRegionServers) {
    this.numDeadRegionServers = numDeadRegionServers;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
