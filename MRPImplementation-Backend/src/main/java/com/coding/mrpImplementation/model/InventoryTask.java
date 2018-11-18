package com.coding.mrpImplementation.model;

public class InventoryTask extends Task {

    private int quantity;
    private Material material;
    private Supplier supplier;
    private MaterialControl materialControl;


    public InventoryTask() {}

    public InventoryTask(String id, int initDate, int finishDate, String description, boolean finished, int quantity, Material material, Supplier supplier, MaterialControl materialControl) {
        super(id, initDate, finishDate, description, finished);
        this.quantity = quantity;
        this.material = material;
        this.supplier = supplier;
        this.materialControl = materialControl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public MaterialControl getMaterialControl() {
        return materialControl;
    }

    public void setMaterialControl(MaterialControl materialControl) {
        this.materialControl = materialControl;
    }
}
