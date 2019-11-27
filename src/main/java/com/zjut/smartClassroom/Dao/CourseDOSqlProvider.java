package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.CourseDO;
import com.zjut.smartClassroom.dataObject.CourseDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.CourseDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.CourseDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CourseDOSqlProvider {

    public String countByExample(CourseDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CourseDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CourseDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course");
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseName() != null) {
            sql.VALUES("course_name", "#{courseName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseCredit() != null) {
            sql.VALUES("course_credit", "#{courseCredit,jdbcType=INTEGER}");
        }
        
        if (record.getCourseMethod() != null) {
            sql.VALUES("course_method", "#{courseMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePicurl() != null) {
            sql.VALUES("course_picUrl", "#{coursePicurl,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePptUrl() != null) {
            sql.VALUES("course_ppt_url", "#{coursePptUrl,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CourseDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("course_id");
        } else {
            sql.SELECT("course_id");
        }
        sql.SELECT("course_name");
        sql.SELECT("course_credit");
        sql.SELECT("course_method");
        sql.SELECT("course_picUrl");
        sql.SELECT("course_ppt_url");
        sql.FROM("course");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CourseDO record = (CourseDO) parameter.get("record");
        CourseDOExample example = (CourseDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseName() != null) {
            sql.SET("course_name = #{record.courseName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseCredit() != null) {
            sql.SET("course_credit = #{record.courseCredit,jdbcType=INTEGER}");
        }
        
        if (record.getCourseMethod() != null) {
            sql.SET("course_method = #{record.courseMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePicurl() != null) {
            sql.SET("course_picUrl = #{record.coursePicurl,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePptUrl() != null) {
            sql.SET("course_ppt_url = #{record.coursePptUrl,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        sql.SET("course_name = #{record.courseName,jdbcType=VARCHAR}");
        sql.SET("course_credit = #{record.courseCredit,jdbcType=INTEGER}");
        sql.SET("course_method = #{record.courseMethod,jdbcType=VARCHAR}");
        sql.SET("course_picUrl = #{record.coursePicurl,jdbcType=VARCHAR}");
        sql.SET("course_ppt_url = #{record.coursePptUrl,jdbcType=VARCHAR}");
        
        CourseDOExample example = (CourseDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CourseDO record) {
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        if (record.getCourseName() != null) {
            sql.SET("course_name = #{courseName,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseCredit() != null) {
            sql.SET("course_credit = #{courseCredit,jdbcType=INTEGER}");
        }
        
        if (record.getCourseMethod() != null) {
            sql.SET("course_method = #{courseMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePicurl() != null) {
            sql.SET("course_picUrl = #{coursePicurl,jdbcType=VARCHAR}");
        }
        
        if (record.getCoursePptUrl() != null) {
            sql.SET("course_ppt_url = #{coursePptUrl,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("course_id = #{courseId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CourseDOExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}