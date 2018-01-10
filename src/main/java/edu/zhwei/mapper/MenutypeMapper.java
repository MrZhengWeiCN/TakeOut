package edu.zhwei.mapper;

import edu.zhwei.pojo.Menutype;
import edu.zhwei.pojo.MenutypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenutypeMapper {
    int countByExample(MenutypeExample example);

    int deleteByExample(MenutypeExample example);

    int deleteByPrimaryKey(Integer menuTypeId);

    int insert(Menutype record);

    int insertSelective(Menutype record);

    List<Menutype> selectByExample(MenutypeExample example);

    Menutype selectByPrimaryKey(Integer menuTypeId);

    int updateByExampleSelective(@Param("record") Menutype record, @Param("example") MenutypeExample example);

    int updateByExample(@Param("record") Menutype record, @Param("example") MenutypeExample example);

    int updateByPrimaryKeySelective(Menutype record);

    int updateByPrimaryKey(Menutype record);
}