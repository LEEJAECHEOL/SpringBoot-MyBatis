package com.cos.myBatisex01.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DataAccessConfig {

   // SqlSession을 만들어야함. 왜 Session일까? 세션이라고 만든이유는 연결과 인증이 끝났다는거임.
   // SqlSession을 만들기 위한 공장 생성
   // 1. DataSource 등록 => yml에 만든 datasource를 가져온거임. yml에 설정된건 IoC에 등록되기 때문. 그래서 가져올 수 있음.
   // 2. xml 파일 연결.
   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { //DataSource는 나중에 di로 넣어줄꺼임
      SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
      sessionFactoryBean.setDataSource(dataSource); 
      sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*.xml")); //xml 파일을 모두 로드
      return sessionFactoryBean.getObject();
   }
   
   // 순서대로 @bean을 읽기 떄문에 100% 주입됨
   // SqlSession 만들기
   // 1. SqlSessiond은 인터페이스여서 직접 만들면 번거롭기 때문에 SqlSessionTemplate를 사용(편함.)
   @Bean
   public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
      return new SqlSessionTemplate(sqlSessionFactory);
   }
   // 설정 끝. 다음에 설정할때는 getResource안에만 바꿔주면 됨.
}