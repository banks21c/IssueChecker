package com.goodbyenote.issuechecker.common.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
public interface SqlSession4Reference extends Closeable {
  <T> T selectOne(String statement);
  <T> T selectOne(String statement, Object parameter);
  <E> List<E> selectList(String statement);
  <E> List<E> selectList(String statement, Object parameter);
  <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds);
  <K, V> Map<K, V> selectMap(String statement, String mapKey);
  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey);
  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds);
  void select(String statement, Object parameter, ResultHandler handler);
  void select(String statement, ResultHandler handler);
  void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler);
  int insert(String statement);
  int insert(String statement, Object parameter);
  int update(String statement);
  int update(String statement, Object parameter);
  int delete(String statement);
  int delete(String statement, Object parameter);
  void commit();
  void commit(boolean force);
  void rollback();
  void rollback(boolean force);
  List<BatchResult> flushStatements();
  void close();
  void clearCache();
  Configuration getConfiguration();
  <T> T getMapper(Class<T> type);
  Connection getConnection();
}