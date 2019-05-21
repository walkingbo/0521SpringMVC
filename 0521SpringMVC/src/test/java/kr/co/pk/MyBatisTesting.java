package kr.co.pk;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.pk.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
//locations에 설정된 스프링 설정 파일을 실행 
//spring 디렉토리 안에 있는 모든 xml 파일의 내용을 실행 
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyBatisTesting {
	//여기서 테스트가 가능하도록 하기 위해서
	//Service 클래스의 매개변수를 HttpServletRequest를
	//사용하지 않으려고 합니다. 
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testing() {
		System.out.println(sqlSession);
		System.out.println(sqlSession.selectList("itemMapper.allItem"));
		
	}
	
	@Test
	public void testing1() {
		Item item = sqlSession.selectOne("itemMapper.getItem",8);
		System.out.println(item);
		
	}
}
