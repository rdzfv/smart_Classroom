package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.AnswerDO;
import com.zjut.smartClassroom.dataObject.AnswerDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.AnswerDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.AnswerDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AnswerDOSqlProvider {

    public String countByExample(AnswerDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("answer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AnswerDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("answer");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AnswerDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("answer");
        
        if (record.getAnsId() != null) {
            sql.VALUES("ans_id", "#{ansId,jdbcType=INTEGER}");
        }
        
        if (record.getStudentId() != null) {
            sql.VALUES("student_id", "#{studentId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetId() != null) {
            sql.VALUES("problem_set_id", "#{problemSetId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemId() != null) {
            sql.VALUES("problem_id", "#{problemId,jdbcType=INTEGER}");
        }
        
        if (record.getStudentAns() != null) {
            sql.VALUES("student_ans", "#{studentAns,jdbcType=TINYINT}");
        }
        
        if (record.getIstrue() != null) {
            sql.VALUES("istrue", "#{istrue,jdbcType=TINYINT}");
        }
        
        if (record.getRightAns() != null) {
            sql.VALUES("right_ans", "#{rightAns,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AnswerDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ans_id");
        } else {
            sql.SELECT("ans_id");
        }
        sql.SELECT("student_id");
        sql.SELECT("problem_set_id");
        sql.SELECT("problem_id");
        sql.SELECT("student_ans");
        sql.SELECT("istrue");
        sql.SELECT("right_ans");
        sql.FROM("answer");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AnswerDO record = (AnswerDO) parameter.get("record");
        AnswerDOExample example = (AnswerDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        if (record.getAnsId() != null) {
            sql.SET("ans_id = #{record.ansId,jdbcType=INTEGER}");
        }
        
        if (record.getStudentId() != null) {
            sql.SET("student_id = #{record.studentId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetId() != null) {
            sql.SET("problem_set_id = #{record.problemSetId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemId() != null) {
            sql.SET("problem_id = #{record.problemId,jdbcType=INTEGER}");
        }
        
        if (record.getStudentAns() != null) {
            sql.SET("student_ans = #{record.studentAns,jdbcType=TINYINT}");
        }
        
        if (record.getIstrue() != null) {
            sql.SET("istrue = #{record.istrue,jdbcType=TINYINT}");
        }
        
        if (record.getRightAns() != null) {
            sql.SET("right_ans = #{record.rightAns,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        sql.SET("ans_id = #{record.ansId,jdbcType=INTEGER}");
        sql.SET("student_id = #{record.studentId,jdbcType=INTEGER}");
        sql.SET("problem_set_id = #{record.problemSetId,jdbcType=INTEGER}");
        sql.SET("problem_id = #{record.problemId,jdbcType=INTEGER}");
        sql.SET("student_ans = #{record.studentAns,jdbcType=TINYINT}");
        sql.SET("istrue = #{record.istrue,jdbcType=TINYINT}");
        sql.SET("right_ans = #{record.rightAns,jdbcType=TINYINT}");
        
        AnswerDOExample example = (AnswerDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AnswerDO record) {
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        if (record.getStudentId() != null) {
            sql.SET("student_id = #{studentId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetId() != null) {
            sql.SET("problem_set_id = #{problemSetId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemId() != null) {
            sql.SET("problem_id = #{problemId,jdbcType=INTEGER}");
        }
        
        if (record.getStudentAns() != null) {
            sql.SET("student_ans = #{studentAns,jdbcType=TINYINT}");
        }
        
        if (record.getIstrue() != null) {
            sql.SET("istrue = #{istrue,jdbcType=TINYINT}");
        }
        
        if (record.getRightAns() != null) {
            sql.SET("right_ans = #{rightAns,jdbcType=TINYINT}");
        }
        
        sql.WHERE("ans_id = #{ansId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AnswerDOExample example, boolean includeExamplePhrase) {
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