package com.webank.wecube.platform.core.jpa.workflow;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webank.wecube.platform.core.entity.workflow.ProcDefInfoEntity;

@Repository
public interface ProcDefInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProcDefInfoEntity record);

    int insertSelective(ProcDefInfoEntity record);

    ProcDefInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProcDefInfoEntity record);

    int updateByPrimaryKey(ProcDefInfoEntity record);

//    @Query("select t from ProcDefInfoEntity t "
//            + " where t.active = true and (t.status = 'deployed' or t.status = 'draft')")
    List<ProcDefInfoEntity> findAllDeployedOrDraftProcDefs();

//    @Query("select t from ProcDefInfoEntity t "
//            + " where t.id=:procId and t.active = true and (t.status = 'deployed' or t.status = 'draft')")
//    ProcDefInfoEntity findAllDeployedOrDraftProcDefsByProcId(@Param("procId") String procId);

//    @Query("select t from ProcDefInfoEntity t " + " where t.active = true and t.status = 'deployed' ")
//    List<ProcDefInfoEntity> findAllDeployedProcDefs();

//    @Query("select t from ProcDefInfoEntity t " + " where t.id=:procId and t.active = true and t.status = 'deployed'")
//    ProcDefInfoEntity findAllDeployedProcDefsByProcId(@Param("procId") String procId);

    @Query("select t from ProcDefInfoEntity t " + " where t.procDefName = :procDefName and t.active = true "
            + " and t.status = 'deployed' and t.deleted = false ")
    List<ProcDefInfoEntity> findAllDeployedProcDefsByProcDefName(@Param("procDefName") String procDefName);

    @Query("select t from ProcDefInfoEntity t "
            + " where t.active = true and t.deleted = false and t.procDefKey = :procDefKey and t.status = :status")
    List<ProcDefInfoEntity> findAllDeployedProcDefsByProcDefKey(@Param("procDefKey") String procDefKey,
            @Param("status") String status);

}