package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Promocodes type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Promocodes", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Promocodes implements Model {
  public static final QueryField ID = field("Promocodes", "id");
  public static final QueryField PROMO_CODE = field("Promocodes", "promoCode");
  public static final QueryField EXPIRE_DATE = field("Promocodes", "expireDate");
  public static final QueryField DISCOUNT_PERCENTAGE = field("Promocodes", "discountPercentage");
  public static final QueryField V = field("Promocodes", "__v");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String promoCode;
  private final @ModelField(targetType="String") String expireDate;
  private final @ModelField(targetType="String") String discountPercentage;
  private final @ModelField(targetType="String") String __v;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getPromoCode() {
      return promoCode;
  }
  
  public String getExpireDate() {
      return expireDate;
  }
  
  public String getDiscountPercentage() {
      return discountPercentage;
  }
  
  public String getV() {
      return __v;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Promocodes(String id, String promoCode, String expireDate, String discountPercentage, String __v) {
    this.id = id;
    this.promoCode = promoCode;
    this.expireDate = expireDate;
    this.discountPercentage = discountPercentage;
    this.__v = __v;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Promocodes promocodes = (Promocodes) obj;
      return ObjectsCompat.equals(getId(), promocodes.getId()) &&
              ObjectsCompat.equals(getPromoCode(), promocodes.getPromoCode()) &&
              ObjectsCompat.equals(getExpireDate(), promocodes.getExpireDate()) &&
              ObjectsCompat.equals(getDiscountPercentage(), promocodes.getDiscountPercentage()) &&
              ObjectsCompat.equals(getV(), promocodes.getV()) &&
              ObjectsCompat.equals(getCreatedAt(), promocodes.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), promocodes.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPromoCode())
      .append(getExpireDate())
      .append(getDiscountPercentage())
      .append(getV())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Promocodes {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("promoCode=" + String.valueOf(getPromoCode()) + ", ")
      .append("expireDate=" + String.valueOf(getExpireDate()) + ", ")
      .append("discountPercentage=" + String.valueOf(getDiscountPercentage()) + ", ")
      .append("__v=" + String.valueOf(getV()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Promocodes justId(String id) {
    return new Promocodes(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      promoCode,
      expireDate,
      discountPercentage,
      __v);
  }
  public interface BuildStep {
    Promocodes build();
    BuildStep id(String id);
    BuildStep promoCode(String promoCode);
    BuildStep expireDate(String expireDate);
    BuildStep discountPercentage(String discountPercentage);
    BuildStep v(String v);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String promoCode;
    private String expireDate;
    private String discountPercentage;
    private String __v;
    public Builder() {
      
    }
    
    private Builder(String id, String promoCode, String expireDate, String discountPercentage, String __v) {
      this.id = id;
      this.promoCode = promoCode;
      this.expireDate = expireDate;
      this.discountPercentage = discountPercentage;
      this.__v = __v;
    }
    
    @Override
     public Promocodes build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Promocodes(
          id,
          promoCode,
          expireDate,
          discountPercentage,
          __v);
    }
    
    @Override
     public BuildStep promoCode(String promoCode) {
        this.promoCode = promoCode;
        return this;
    }
    
    @Override
     public BuildStep expireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }
    
    @Override
     public BuildStep discountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
        return this;
    }
    
    @Override
     public BuildStep v(String v) {
        this.__v = v;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String promoCode, String expireDate, String discountPercentage, String v) {
      super(id, promoCode, expireDate, discountPercentage, __v);
      
    }
    
    @Override
     public CopyOfBuilder promoCode(String promoCode) {
      return (CopyOfBuilder) super.promoCode(promoCode);
    }
    
    @Override
     public CopyOfBuilder expireDate(String expireDate) {
      return (CopyOfBuilder) super.expireDate(expireDate);
    }
    
    @Override
     public CopyOfBuilder discountPercentage(String discountPercentage) {
      return (CopyOfBuilder) super.discountPercentage(discountPercentage);
    }
    
    @Override
     public CopyOfBuilder v(String v) {
      return (CopyOfBuilder) super.v(v);
    }
  }
  

  public static class PromocodesIdentifier extends ModelIdentifier<Promocodes> {
    private static final long serialVersionUID = 1L;
    public PromocodesIdentifier(String id) {
      super(id);
    }
  }
  
}
