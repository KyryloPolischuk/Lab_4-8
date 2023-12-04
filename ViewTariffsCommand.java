package com.Menu;

import com.Tariff.TariffList;

public class ViewTariffsCommand implements Command {

    private final TariffList tariffList;

    public ViewTariffsCommand(TariffList tariffList) {
        this.tariffList = tariffList;
    }

    @Override
    public void execute() {
        // Виведіть список тарифів
        System.out.println(tariffList);
    }
}
