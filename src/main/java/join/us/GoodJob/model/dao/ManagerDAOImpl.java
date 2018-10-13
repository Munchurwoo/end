package join.us.GoodJob.model.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDAOImpl implements ManagerDAO {
	@Resource
	SqlSessionTemplate template;
}
