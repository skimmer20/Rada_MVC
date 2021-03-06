package com.yura.rada.service;

import com.yura.rada.model.Deputat;

import java.util.List;

/**
 * @author yuriismac on 2020-06-06.
 * @project VerkhovnaRada
 */
public interface DeputatService {
    void addDeputat(Deputat deputat);

    void updateDeputat(Deputat deputat);

    void removeDeputat(int id);

    Deputat getDeputatById(int id);

    List<Deputat> listDeputats();
}
