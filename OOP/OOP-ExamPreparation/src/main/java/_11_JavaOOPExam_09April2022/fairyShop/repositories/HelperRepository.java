package _11_JavaOOPExam_09April2022.fairyShop.repositories;

import _11_JavaOOPExam_09April2022.fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {

    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }

    @Override
    public void add(Helper helper) {
        this.helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {

        return this.helpers
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
