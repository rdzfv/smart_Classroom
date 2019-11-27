package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.TeacherDO;
import com.zjut.smartClassroom.dataObject.TeacherDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.TeacherDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.TeacherDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TeacherDOSqlProvider {

    public String countByExample(TeacherDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("teacher");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TeacherDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("teacher");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TeacherDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teacher");
        
        if (record.getTeacherId() != null) {
            sql.VALUES("teacher_id", "#{teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherName() != null) {
            sql.VALUES("teacher_name", "#{teacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherAccount() != null) {
            sql.VALUES("teacher_account", "#{teacherAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherPassword() != null) {
            sql.VALUES("teacher_password", "#{teacherPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherSex() != null) {
            sql.VALUES("teacher_sex", "#{teacherSex,jdbcType=TINYINT}");
        }
        
        if (record.getTeacherPhone() != null) {
            sql.VALUES("teacher_phone", "#{teacherPhone,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TeacherDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("teacher_id");
        } else {
            sql.SELECT("teacher_id");
        }
        sql.SELECT("teacher_name");
        sql.SELECT("teacher_account");
        sql.SELECT("teacher_password");
        sql.SELECT("teacher_sex");
        sql.SELECT("teacher_phone");
        sql.FROM("teacher");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TeacherDO record = (TeacherDO) parameter.get("record");
        TeacherDOExample example = (TeacherDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("teacher");
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherName() != null) {
            sql.SET("teacher_name = #{record.teacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherAccount() != null) {
            sql.SET("teacher_account = #{record.teacherAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherPassword() != null) {
            sql.SET("teacher_password = #{record.teacherPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherSex() != null) {
            sql.SET("teacher_sex = #{record.teacherSex,jdbcType=TINYINT}");
        }
        
        if (record.getTeacherPhone() != null) {
            sql.SET("teacher_phone = #{record.teacherPhone,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("teacher");
        
        sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        sql.SET("teacher_name = #{record.teacherName,jdbcType=VARCHAR}");
        sql.SET("teacher_account = #{record.teacherAccount,jdbcType=VARCHAR}");
        sql.SET("teacher_password = #{record.teacherPassword,jdbcType=VARCHAR}");
        sql.SET("teacher_sex = #{record.teacherSex,jdbcType=TINYINT}");
        sql.SET("teacher_phone = #{record.teacherPhone,jdbcType=VARCHAR}");
        
        TeacherDOExample example = (TeacherDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TeacherDO record) {
        SQL sql = new SQL();
        sql.UPDATE("teacher");
        
        if (record.getTeacherName() != null) {
            sql.SET("teacher_name = #{teacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherAccount() != null) {
            sql.SET("teacher_account = #{teacherAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherPassword() != null) {
            sql.SET("teacher_password = #{teacherPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherSex() != null) {
            sql.SET("teacher_sex = #{teacherSex,jdbcType=TINYINT}");
        }
        
        if (record.getTeacherPhone() != null) {
            sql.SET("teacher_phone = #{teacherPhone,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("teacher_id = #{teacherId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TeacherDOExample example, boolean includeExamplePhrase) {
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