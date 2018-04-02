package com.imooc.bigdata.hbase.monitor.entity;

import java.util.List;

/**
 * Created by jixin on 18-3-24.
 */
public class HdfsSummary {

  //"name": "Hadoop:service=NameNode,name=NameNodeInfo"
  //总空间大小 GB
  private double total;
  //hdfs已使用的空间大小 GB
  private double dfsUsed;
  //hdfs已使用空间百分比
  private double percentUsed;
  //hdfs空闲空间 GB
  private double dfsFree;
  //hdfs是否处于safemode
  private String safeMode;
  //非hdfs空间大小 GB
  private double nonDfsUsed;
  //集群该namespace的hdfs使用容量大小
  private double blockPoolUsedSpace;
  //集群该namespace的hdfs使用容量所占百分比
  private double percentBlockPoolUsed;
  private double percentRemaining;
  //集群总的block数
  private int totalBlocks;
  //集群总的文件数
  private int totalFiles;
  //集群丢失的block数量
  private int missingBlocks;
  //处于可用状态的datanode汇总
  private List<DataNodeInfo> liveDataNodeInfos;
  //处于不可用状态的datanode汇总
  private List<DataNodeInfo> deadDataNodeInfos;
  //"name": "Hadoop:service=NameNode,name=FSNamesystemState"
  //处于可用状态的datanode数量
  private int numLiveDataNodes;
  //处于不可用状态的datanode数量
  private int numDeadDataNodes;
  //坏盘的数量
  private int volumeFailuresTotal;

  public void printInfo() {

    System.out.println("HDFS SUMMARY INFO");
    System.out.println(String
        .format("totalBlocks:%s\ntotalFiles:%s\nnumLiveDataNodes:%s", totalBlocks, totalFiles,
            numLiveDataNodes));
    liveDataNodeInfos.forEach(node -> {
      System.out.println(
          String.format("nodeName:%s\nnumBlocks:%s", node.getNodeName(), node.getNumBlocks()));
    });
    System.out.println("----------------------");
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public double getDfsUsed() {
    return dfsUsed;
  }

  public void setDfsUsed(double dfsUsed) {
    this.dfsUsed = dfsUsed;
  }

  public double getPercentUsed() {
    return percentUsed;
  }

  public void setPercentUsed(double percentUsed) {
    this.percentUsed = percentUsed;
  }

  public double getDfsFree() {
    return dfsFree;
  }

  public void setDfsFree(double dfsFree) {
    this.dfsFree = dfsFree;
  }

  public String getSafeMode() {
    return safeMode;
  }

  public void setSafeMode(String safeMode) {
    this.safeMode = safeMode;
  }

  public double getNonDfsUsed() {
    return nonDfsUsed;
  }

  public void setNonDfsUsed(double nonDfsUsed) {
    this.nonDfsUsed = nonDfsUsed;
  }

  public double getBlockPoolUsedSpace() {
    return blockPoolUsedSpace;
  }

  public void setBlockPoolUsedSpace(double blockPoolUsedSpace) {
    this.blockPoolUsedSpace = blockPoolUsedSpace;
  }

  public double getPercentBlockPoolUsed() {
    return percentBlockPoolUsed;
  }

  public void setPercentBlockPoolUsed(double percentBlockPoolUsed) {
    this.percentBlockPoolUsed = percentBlockPoolUsed;
  }

  public double getPercentRemaining() {
    return percentRemaining;
  }

  public void setPercentRemaining(double percentRemaining) {
    this.percentRemaining = percentRemaining;
  }

  public int getTotalBlocks() {
    return totalBlocks;
  }

  public void setTotalBlocks(int totalBlocks) {
    this.totalBlocks = totalBlocks;
  }

  public int getTotalFiles() {
    return totalFiles;
  }

  public void setTotalFiles(int totalFiles) {
    this.totalFiles = totalFiles;
  }

  public int getMissingBlocks() {
    return missingBlocks;
  }

  public void setMissingBlocks(int missingBlocks) {
    this.missingBlocks = missingBlocks;
  }

  public List<DataNodeInfo> getLiveDataNodeInfos() {
    return liveDataNodeInfos;
  }

  public void setLiveDataNodeInfos(
      List<DataNodeInfo> liveDataNodeInfos) {
    this.liveDataNodeInfos = liveDataNodeInfos;
  }

  public List<DataNodeInfo> getDeadDataNodeInfos() {
    return deadDataNodeInfos;
  }

  public void setDeadDataNodeInfos(
      List<DataNodeInfo> deadDataNodeInfos) {
    this.deadDataNodeInfos = deadDataNodeInfos;
  }

  public int getNumLiveDataNodes() {
    return numLiveDataNodes;
  }

  public void setNumLiveDataNodes(int numLiveDataNodes) {
    this.numLiveDataNodes = numLiveDataNodes;
  }

  public int getNumDeadDataNodes() {
    return numDeadDataNodes;
  }

  public void setNumDeadDataNodes(int numDeadDataNodes) {
    this.numDeadDataNodes = numDeadDataNodes;
  }

  public int getVolumeFailuresTotal() {
    return volumeFailuresTotal;
  }

  public void setVolumeFailuresTotal(int volumeFailuresTotal) {
    this.volumeFailuresTotal = volumeFailuresTotal;
  }
}
