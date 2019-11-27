package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ProblemDO;
import com.zjut.smartClassroom.dataObject.ProblemDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.ProblemDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.ProblemDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProblemDOSqlProvider {

    public String countByExample(ProblemDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("problem");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProblemDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("problem");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProblemDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("problem");
        
        if (record.getProblemId() != null) {
            sql.VALUES("problem_id", "#{problemId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemInformation() != null) {
            sql.VALUES("problem_information", "#{problemInformation,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemChoices() != null) {
            sql.VALUES("problem_choices", "#{problemChoices,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemExplain() != null) {
            sql.VALUES("problem_explain", "#{problemExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemAns() != null) {
            sql.VALUES("problem_ans", "#{problemAns,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProblemDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("problem_id");
        } else {
            sql.SELECT("problem_id");
        }
        sql.SELECT("problem_information");
        sql.SELECT("problem_choices");
        sql.SELECT("problem_explain");
        sql.SELECT("problem_ans");
        sql.FROM("problem");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProblemDO record = (ProblemDO) parameter.get("record");
        ProblemDOExample example = (ProblemDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("problem");
        
        if (record.getProblemId() != null) {
            sql.SET("problem_id = #{record.problemId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemInformation() != null) {
            sql.SET("problem_information = #{record.problemInformation,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemChoices() != null) {
            sql.SET("problem_choices = #{record.problemChoices,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemExplain() != null) {
            sql.SET("problem_explain = #{record.problemExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemAns() != null) {
            sql.SET("problem_ans = #{record.problemAns,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("problem");
        
        sql.SET("problem_id = #{record.problemId,jdbcType=INTEGER}");
        sql.SET("problem_information = #{record.problemInformation,jdbcType=VARCHAR}");
        sql.SET("problem_choices = #{record.problemChoices,jdbcType=VARCHAR}");
        sql.SET("problem_explain = #{record.problemExplain,jdbcType=VARCHAR}");
        sql.SET("problem_ans = #{record.problemAns,jdbcType=INTEGER}");
        
        ProblemDOExample example = (ProblemDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProblemDO record) {
        SQL sql = new SQL();
        sql.UPDATE("problem");
        
        if (record.getProblemInformation() != null) {
            sql.SET("problem_information = #{problemInformation,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemChoices() != null) {
            sql.SET("problem_choices = #{problemChoices,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemExplain() != null) {
            sql.SET("problem_explain = #{problemExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemAns() != null) {
            sql.SET("problem_ans = #{problemAns,jdbcType=INTEGER}");
        }
        
        sql.WHERE("problem_id = #{problemId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProblemDOExample example, boolean includeExamplePhrase) {
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