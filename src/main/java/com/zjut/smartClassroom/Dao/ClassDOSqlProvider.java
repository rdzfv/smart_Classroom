package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ClassDO;
import com.zjut.smartClassroom.dataObject.ClassDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.ClassDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.ClassDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ClassDOSqlProvider {

    public String countByExample(ClassDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ClassDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ClassDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("class");
        
        if (record.getTeacherId() != null) {
            sql.VALUES("teacher_id", "#{teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getClassClassroom() != null) {
            sql.VALUES("class_classroom", "#{classClassroom,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            sql.VALUES("class_name", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassOpenyear() != null) {
            sql.VALUES("class_openyear", "#{classOpenyear,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ClassDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("teacher_id");
        } else {
            sql.SELECT("teacher_id");
        }
        sql.SELECT("course_id");
        sql.SELECT("class_classroom");
        sql.SELECT("class_name");
        sql.SELECT("class_openyear");
        sql.FROM("class");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ClassDO record = (ClassDO) parameter.get("record");
        ClassDOExample example = (ClassDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        }
        
        if (record.getClassClassroom() != null) {
            sql.SET("class_classroom = #{record.classClassroom,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            sql.SET("class_name = #{record.className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassOpenyear() != null) {
            sql.SET("class_openyear = #{record.classOpenyear,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        sql.SET("class_classroom = #{record.classClassroom,jdbcType=VARCHAR}");
        sql.SET("class_name = #{record.className,jdbcType=VARCHAR}");
        sql.SET("class_openyear = #{record.classOpenyear,jdbcType=INTEGER}");
        
        ClassDOExample example = (ClassDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ClassDO record) {
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        if (record.getClassClassroom() != null) {
            sql.SET("class_classroom = #{classClassroom,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            sql.SET("class_name = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassOpenyear() != null) {
            sql.SET("class_openyear = #{classOpenyear,jdbcType=INTEGER}");
        }
        
        sql.WHERE("teacher_id = #{teacherId,jdbcType=INTEGER}");
        sql.WHERE("course_id = #{courseId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ClassDOExample example, boolean includeExamplePhrase) {
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