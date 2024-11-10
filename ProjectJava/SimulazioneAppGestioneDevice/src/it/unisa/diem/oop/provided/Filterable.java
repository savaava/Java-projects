package it.unisa.diem.oop.provided;

import it.unisa.diem.oop.developed.group77.DeviceStore;
import it.unisa.diem.oop.developed.group77.Device;
import java.util.Comparator;

public interface Filterable {
    DeviceStore filter(DeviceFilter d, Comparator<Device> c);
}
