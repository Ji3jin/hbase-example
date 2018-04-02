package com.imooc.bigdata.hbase.monitor.entity;

/**
 * Created by jixin on 18-3-24.
 */
public class RegionServerInfo {
  //regionserver的hostname
  private String hostName;
  //"name" : "Hadoop:service=HBase,name=RegionServer,sub=Server"
  //Store个数
  private int storeCount;
  //Regionserver管理region数量
  private int regionCount;
  //Storefile个数
  private int storeFileCount;
  //Memstore大小
  private double memStoreSize;
  //Storefile大小
  private double storeFileSize;
  //该regionserver所管理的表索引大小
  private double staticIndexSize;
  //总请求数
  private int totalRequestCount;
  //读请求数
  private int readRequestCount;
  //写请求数
  private int writeRequestCount;
  //合并cell个数
  private int compactedCellsCount;
  //大合并cell个数
  private int majorCompactedCellsCount;
  //flush到磁盘的大小
  private double flushedCellsSize;
  //因memstore大于阈值而引发flush的次数
  private int blockedRequestCount;
  //region分裂请求次数
  private int splitRequestCount;
  //region分裂成功次数
  private int splitSuccessCount;
  //请求完成时间超过1000ms的次数
  private int slowGetCount;
  //"name" : "Hadoop:service=HBase,name=RegionServer,sub=IPC"
  //该regionserver打开的连接数
  private int numOpenConnections;
  //rpc handler数
  private int numActiveHandler;
  //收到数据量 GB
  private double sentBytes;
  //发出数据量 GB
  private double receivedBytes;

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public int getStoreCount() {
    return storeCount;
  }

  public void setStoreCount(int storeCount) {
    this.storeCount = storeCount;
  }

  public int getRegionCount() {
    return regionCount;
  }

  public void setRegionCount(int regionCount) {
    this.regionCount = regionCount;
  }

  public int getStoreFileCount() {
    return storeFileCount;
  }

  public void setStoreFileCount(int storeFileCount) {
    this.storeFileCount = storeFileCount;
  }

  public double getMemStoreSize() {
    return memStoreSize;
  }

  public void setMemStoreSize(double memStoreSize) {
    this.memStoreSize = memStoreSize;
  }

  public double getStoreFileSize() {
    return storeFileSize;
  }

  public void setStoreFileSize(double storeFileSize) {
    this.storeFileSize = storeFileSize;
  }

  public double getStaticIndexSize() {
    return staticIndexSize;
  }

  public void setStaticIndexSize(double staticIndexSize) {
    this.staticIndexSize = staticIndexSize;
  }

  public int getTotalRequestCount() {
    return totalRequestCount;
  }

  public void setTotalRequestCount(int totalRequestCount) {
    this.totalRequestCount = totalRequestCount;
  }

  public int getReadRequestCount() {
    return readRequestCount;
  }

  public void setReadRequestCount(int readRequestCount) {
    this.readRequestCount = readRequestCount;
  }

  public int getWriteRequestCount() {
    return writeRequestCount;
  }

  public void setWriteRequestCount(int writeRequestCount) {
    this.writeRequestCount = writeRequestCount;
  }

  public int getCompactedCellsCount() {
    return compactedCellsCount;
  }

  public void setCompactedCellsCount(int compactedCellsCount) {
    this.compactedCellsCount = compactedCellsCount;
  }

  public int getMajorCompactedCellsCount() {
    return majorCompactedCellsCount;
  }

  public void setMajorCompactedCellsCount(int majorCompactedCellsCount) {
    this.majorCompactedCellsCount = majorCompactedCellsCount;
  }

  public double getFlushedCellsSize() {
    return flushedCellsSize;
  }

  public void setFlushedCellsSize(double flushedCellsSize) {
    this.flushedCellsSize = flushedCellsSize;
  }

  public int getBlockedRequestCount() {
    return blockedRequestCount;
  }

  public void setBlockedRequestCount(int blockedRequestCount) {
    this.blockedRequestCount = blockedRequestCount;
  }

  public int getSplitRequestCount() {
    return splitRequestCount;
  }

  public void setSplitRequestCount(int splitRequestCount) {
    this.splitRequestCount = splitRequestCount;
  }

  public int getSplitSuccessCount() {
    return splitSuccessCount;
  }

  public void setSplitSuccessCount(int splitSuccessCount) {
    this.splitSuccessCount = splitSuccessCount;
  }

  public int getSlowGetCount() {
    return slowGetCount;
  }

  public void setSlowGetCount(int slowGetCount) {
    this.slowGetCount = slowGetCount;
  }

  public int getNumOpenConnections() {
    return numOpenConnections;
  }

  public void setNumOpenConnections(int numOpenConnections) {
    this.numOpenConnections = numOpenConnections;
  }

  public int getNumActiveHandler() {
    return numActiveHandler;
  }

  public void setNumActiveHandler(int numActiveHandler) {
    this.numActiveHandler = numActiveHandler;
  }

  public double getSentBytes() {
    return sentBytes;
  }

  public void setSentBytes(double sentBytes) {
    this.sentBytes = sentBytes;
  }

  public double getReceivedBytes() {
    return receivedBytes;
  }

  public void setReceivedBytes(double receivedBytes) {
    this.receivedBytes = receivedBytes;
  }
}
