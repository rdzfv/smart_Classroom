package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ProblemSetDO;
import com.zjut.smartClassroom.dataObject.ProblemSetDOExample.Criteria;
import com.zjut.smartClassroom.dataObject.ProblemSetDOExample.Criterion;
import com.zjut.smartClassroom.dataObject.ProblemSetDOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProblemSetDOSqlProvider {

    public String countByExample(ProblemSetDOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("problem_set");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProblemSetDOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("problem_set");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProblemSetDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("problem_set");
        
        if (record.getProblemSetId() != null) {
            sql.VALUES("problem_set_id", "#{problemSetId,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherId() != null) {
            sql.VALUES("teacher_id", "#{teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemReleaseTime() != null) {
            sql.VALUES("problem_release_time", "#{problemReleaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaperId() != null) {
            sql.VALUES("paper_id", "#{paperId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetName() != null) {
            sql.VALUES("problem_set_name", "#{problemSetName,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetDetail() != null) {
            sql.VALUES("problem_set_detail", "#{problemSetDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetPicurl() != null) {
            sql.VALUES("problem_set_picUrl", "#{problemSetPicurl,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProblemSetDOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("problem_set_id");
        } else {
            sql.SELECT("problem_set_id");
        }
        sql.SELECT("teacher_id");
        sql.SELECT("course_id");
        sql.SELECT("problem_release_time");
        sql.SELECT("paper_id");
        sql.SELECT("problem_set_name");
        sql.SELECT("problem_set_detail");
        sql.SELECT("problem_set_picUrl");
        sql.FROM("problem_set");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProblemSetDO record = (ProblemSetDO) parameter.get("record");
        ProblemSetDOExample example = (ProblemSetDOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("problem_set");
        
        if (record.getProblemSetId() != null) {
            sql.SET("problem_set_id = #{record.problemSetId,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemReleaseTime() != null) {
            sql.SET("problem_release_time = #{record.problemReleaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaperId() != null) {
            sql.SET("paper_id = #{record.paperId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetName() != null) {
            sql.SET("problem_set_name = #{record.problemSetName,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetDetail() != null) {
            sql.SET("problem_set_detail = #{record.problemSetDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetPicurl() != null) {
            sql.SET("problem_set_picUrl = #{record.problemSetPicurl,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("problem_set");
        
        sql.SET("problem_set_id = #{record.problemSetId,jdbcType=INTEGER}");
        sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        sql.SET("course_id = #{record.courseId,jdbcType=INTEGER}");
        sql.SET("problem_release_time = #{record.problemReleaseTime,jdbcType=TIMESTAMP}");
        sql.SET("paper_id = #{record.paperId,jdbcType=INTEGER}");
        sql.SET("problem_set_name = #{record.problemSetName,jdbcType=VARCHAR}");
        sql.SET("problem_set_detail = #{record.problemSetDetail,jdbcType=VARCHAR}");
        sql.SET("problem_set_picUrl = #{record.problemSetPicurl,jdbcType=VARCHAR}");
        
        ProblemSetDOExample example = (ProblemSetDOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProblemSetDO record) {
        SQL sql = new SQL();
        sql.UPDATE("problem_set");
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{teacherId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemReleaseTime() != null) {
            sql.SET("problem_release_time = #{problemReleaseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaperId() != null) {
            sql.SET("paper_id = #{paperId,jdbcType=INTEGER}");
        }
        
        if (record.getProblemSetName() != null) {
            sql.SET("problem_set_name = #{problemSetName,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetDetail() != null) {
            sql.SET("problem_set_detail = #{problemSetDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getProblemSetPicurl() != null) {
            sql.SET("problem_set_picUrl = #{problemSetPicurl,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("problem_set_id = #{problemSetId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProblemSetDOExample example, boolean includeExamplePhrase) {
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