package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "mac_menu", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "item_name")
    private String itemName;
    @Basic
    @Column(name = "serving_size")
    private BigDecimal servingSize;
    @Basic
    @Column(name = "calories")
    private Integer calories;
    @Basic
    @Column(name = "fat_calories")
    private Integer fatCalories;
    @Basic
    @Column(name = "total_fat")
    private Integer totalFat;
    @Basic
    @Column(name = "saturated_fat")
    private Integer saturatedFat;
    @Basic
    @Column(name = "cholesterole")
    private Integer cholesterole;
    @Basic
    @Column(name = "sodium")
    private Integer sodium;
    @Basic
    @Column(name = "carbs")
    private Integer carbs;
    @Basic
    @Column(name = "fiber")
    private Integer fiber;
    @Basic
    @Column(name = "sugars")
    private Integer sugars;
    @Basic
    @Column(name = "protein")
    private Integer protein;
    @Basic
    @Column(name = "vit_A")
    private Integer vitA;
    @Basic
    @Column(name = "vit_C")
    private Integer vitC;
    @Basic
    @Column(name = "calcium")
    private Integer calcium;
    @Basic
    @Column(name = "iron")
    private Integer iron;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "cat_id")
    private CategoriesEntity category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getServingSize() {
        return servingSize;
    }

    public void setServingSize(BigDecimal servingSize) {
        this.servingSize = servingSize;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getFatCalories() {
        return fatCalories;
    }

    public void setFatCalories(Integer fatCalories) {
        this.fatCalories = fatCalories;
    }

    public Integer getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(Integer totalFat) {
        this.totalFat = totalFat;
    }

    public Integer getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(Integer saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public Integer getCholesterole() {
        return cholesterole;
    }

    public void setCholesterole(Integer cholesterole) {
        this.cholesterole = cholesterole;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getFiber() {
        return fiber;
    }

    public void setFiber(Integer fiber) {
        this.fiber = fiber;
    }

    public Integer getSugars() {
        return sugars;
    }

    public void setSugars(Integer sugars) {
        this.sugars = sugars;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getVitA() {
        return vitA;
    }

    public void setVitA(Integer vitA) {
        this.vitA = vitA;
    }

    public Integer getVitC() {
        return vitC;
    }

    public void setVitC(Integer vitC) {
        this.vitC = vitC;
    }

    public Integer getCalcium() {
        return calcium;
    }

    public void setCalcium(Integer calcium) {
        this.calcium = calcium;
    }

    public Integer getIron() {
        return iron;
    }

    public void setIron(Integer iron) {
        this.iron = iron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (servingSize != null ? !servingSize.equals(that.servingSize) : that.servingSize != null) return false;
        if (calories != null ? !calories.equals(that.calories) : that.calories != null) return false;
        if (fatCalories != null ? !fatCalories.equals(that.fatCalories) : that.fatCalories != null) return false;
        if (totalFat != null ? !totalFat.equals(that.totalFat) : that.totalFat != null) return false;
        if (saturatedFat != null ? !saturatedFat.equals(that.saturatedFat) : that.saturatedFat != null) return false;
        if (cholesterole != null ? !cholesterole.equals(that.cholesterole) : that.cholesterole != null) return false;
        if (sodium != null ? !sodium.equals(that.sodium) : that.sodium != null) return false;
        if (carbs != null ? !carbs.equals(that.carbs) : that.carbs != null) return false;
        if (fiber != null ? !fiber.equals(that.fiber) : that.fiber != null) return false;
        if (sugars != null ? !sugars.equals(that.sugars) : that.sugars != null) return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (vitA != null ? !vitA.equals(that.vitA) : that.vitA != null) return false;
        if (vitC != null ? !vitC.equals(that.vitC) : that.vitC != null) return false;
        if (calcium != null ? !calcium.equals(that.calcium) : that.calcium != null) return false;
        if (iron != null ? !iron.equals(that.iron) : that.iron != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (servingSize != null ? servingSize.hashCode() : 0);
        result = 31 * result + (calories != null ? calories.hashCode() : 0);
        result = 31 * result + (fatCalories != null ? fatCalories.hashCode() : 0);
        result = 31 * result + (totalFat != null ? totalFat.hashCode() : 0);
        result = 31 * result + (saturatedFat != null ? saturatedFat.hashCode() : 0);
        result = 31 * result + (cholesterole != null ? cholesterole.hashCode() : 0);
        result = 31 * result + (sodium != null ? sodium.hashCode() : 0);
        result = 31 * result + (carbs != null ? carbs.hashCode() : 0);
        result = 31 * result + (fiber != null ? fiber.hashCode() : 0);
        result = 31 * result + (sugars != null ? sugars.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (vitA != null ? vitA.hashCode() : 0);
        result = 31 * result + (vitC != null ? vitC.hashCode() : 0);
        result = 31 * result + (calcium != null ? calcium.hashCode() : 0);
        result = 31 * result + (iron != null ? iron.hashCode() : 0);
        return result;
    }

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity categoriesByCategory) {
        this.category = categoriesByCategory;
    }
}
