package com.imooc.bigdata.hbase.monitor.entity;

/**
 * Created by jixin on 18-3-24.
 */
public class DataNodeInfo {
  //datanode的hostname
  private String nodeName;
  //datanode的ip地址
  private String nodeAddr;
  //datanode的上次链接数量
  private int lastContact;
  //datanode上hdfs的已用空间 GB
  private double usedSpace;
  //datanode的状态
  private String adminState;
  //datanode上非hdfs的空间大小 GB
  private double nonDfsUsedSpace;
  //datanode上的总空间大小
  private double capacity;
  //datanode的block
  private int numBlocks;
  private double remaining;
  private double blockPoolUsed;
  private double blockPoolUsedPerent;

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public String getNodeAddr() {
    return nodeAddr;
  }

  public void setNodeAddr(String nodeAddr) {
    this.nodeAddr = nodeAddr;
  }

  public int getLastContact() {
    return lastContact;
  }

  public void setLastContact(int lastContact) {
    this.lastContact = lastContact;
  }

  public double getUsedSpace() {
    return usedSpace;
  }

  public void setUsedSpace(double usedSpace) {
    this.usedSpace = usedSpace;
  }

  public String getAdminState() {
    return adminState;
  }

  public void setAdminState(String adminState) {
    this.adminState = adminState;
  }

  public double getNonDfsUsedSpace() {
    return nonDfsUsedSpace;
  }

  public void setNonDfsUsedSpace(double nonDfsUsedSpace) {
    this.nonDfsUsedSpace = nonDfsUsedSpace;
  }

  public double getCapacity() {
    return capacity;
  }

  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }

  public int getNumBlocks() {
    return numBlocks;
  }

  public void setNumBlocks(int numBlocks) {
    this.numBlocks = numBlocks;
  }

  public double getRemaining() {
    return remaining;
  }

  public void setRemaining(double remaining) {
    this.remaining = remaining;
  }

  public double getBlockPoolUsed() {
    return blockPoolUsed;
  }

  public void setBlockPoolUsed(double blockPoolUsed) {
    this.blockPoolUsed = blockPoolUsed;
  }

  public double getBlockPoolUsedPerent() {
    return blockPoolUsedPerent;
  }

  public void setBlockPoolUsedPerent(double blockPoolUsedPerent) {
    this.blockPoolUsedPerent = blockPoolUsedPerent;
  }
}
