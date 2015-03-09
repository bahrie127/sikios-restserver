package com.blung.sikios.service;

import com.blung.sikios.domain.LogKios;
import com.blung.sikios.domain.LogSystem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 9/18/13
 * Time: 6:45 AM
 * To change this template use File | Settings | File Templates.
 */
public interface LogService {
    public void save(LogSystem logSystem);

    public void delete(LogSystem logSystem);

    public void deleteMore(LogSystem[] logSystems);

    public LogSystem findLogSystem(Long id);

    public List<LogSystem> findLogSystems();

    public List<LogSystem> findLogSystems(LogSystem logSystem);

    public Long countLogSystems();
    
    /***************************************/

    public void save(LogKios logKios);

    public void delete(LogKios logKios);

    public void deleteMore(LogKios[] logKioss);

    public LogKios findLogKios(Long id);

    public List<LogKios> findLogKioss();

    public List<LogKios> findLogKioss(LogKios logKios);

    public Long countLogKioss();


}
