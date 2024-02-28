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

/** This is an auto generated class representing the Orders type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Orders", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Orders implements Model {
  public static final QueryField ID = field("Orders", "id");
  public static final QueryField ORDER_NUMBER = field("Orders", "order_number");
  public static final QueryField ORDER_DATE = field("Orders", "order_date");
  public static final QueryField STATUS = field("Orders", "status");
  public static final QueryField ORDER_DETAILS = field("Orders", "order_details");
  public static final QueryField CLIENT_DETAILS = field("Orders", "client_details");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String order_number;
  private final @ModelField(targetType="String") String order_date;
  private final @ModelField(targetType="String") String status;
  private final @ModelField(targetType="AWSJSON") String order_details;
  private final @ModelField(targetType="AWSJSON") String client_details;
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
  
  public String getOrderNumber() {
      return order_number;
  }
  
  public String getOrderDate() {
      return order_date;
  }
  
  public String getStatus() {
      return status;
  }
  
  public String getOrderDetails() {
      return order_details;
  }
  
  public String getClientDetails() {
      return client_details;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Orders(String id, String order_number, String order_date, String status, String order_details, String client_details) {
    this.id = id;
    this.order_number = order_number;
    this.order_date = order_date;
    this.status = status;
    this.order_details = order_details;
    this.client_details = client_details;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Orders orders = (Orders) obj;
      return ObjectsCompat.equals(getId(), orders.getId()) &&
              ObjectsCompat.equals(getOrderNumber(), orders.getOrderNumber()) &&
              ObjectsCompat.equals(getOrderDate(), orders.getOrderDate()) &&
              ObjectsCompat.equals(getStatus(), orders.getStatus()) &&
              ObjectsCompat.equals(getOrderDetails(), orders.getOrderDetails()) &&
              ObjectsCompat.equals(getClientDetails(), orders.getClientDetails()) &&
              ObjectsCompat.equals(getCreatedAt(), orders.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), orders.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getOrderNumber())
      .append(getOrderDate())
      .append(getStatus())
      .append(getOrderDetails())
      .append(getClientDetails())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Orders {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("order_number=" + String.valueOf(getOrderNumber()) + ", ")
      .append("order_date=" + String.valueOf(getOrderDate()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("order_details=" + String.valueOf(getOrderDetails()) + ", ")
      .append("client_details=" + String.valueOf(getClientDetails()) + ", ")
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
  public static Orders justId(String id) {
    return new Orders(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      order_number,
      order_date,
      status,
      order_details,
      client_details);
  }
  public interface BuildStep {
    Orders build();
    BuildStep id(String id);
    BuildStep orderNumber(String orderNumber);
    BuildStep orderDate(String orderDate);
    BuildStep status(String status);
    BuildStep orderDetails(String orderDetails);
    BuildStep clientDetails(String clientDetails);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String order_number;
    private String order_date;
    private String status;
    private String order_details;
    private String client_details;
    public Builder() {
      
    }
    
    private Builder(String id, String order_number, String order_date, String status, String order_details, String client_details) {
      this.id = id;
      this.order_number = order_number;
      this.order_date = order_date;
      this.status = status;
      this.order_details = order_details;
      this.client_details = client_details;
    }
    
    @Override
     public Orders build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Orders(
          id,
          order_number,
          order_date,
          status,
          order_details,
          client_details);
    }
    
    @Override
     public BuildStep orderNumber(String orderNumber) {
        this.order_number = orderNumber;
        return this;
    }
    
    @Override
     public BuildStep orderDate(String orderDate) {
        this.order_date = orderDate;
        return this;
    }
    
    @Override
     public BuildStep status(String status) {
        this.status = status;
        return this;
    }
    
    @Override
     public BuildStep orderDetails(String orderDetails) {
        this.order_details = orderDetails;
        return this;
    }
    
    @Override
     public BuildStep clientDetails(String clientDetails) {
        this.client_details = clientDetails;
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
    private CopyOfBuilder(String id, String orderNumber, String orderDate, String status, String orderDetails, String clientDetails) {
      super(id, order_number, order_date, status, order_details, client_details);
      
    }
    
    @Override
     public CopyOfBuilder orderNumber(String orderNumber) {
      return (CopyOfBuilder) super.orderNumber(orderNumber);
    }
    
    @Override
     public CopyOfBuilder orderDate(String orderDate) {
      return (CopyOfBuilder) super.orderDate(orderDate);
    }
    
    @Override
     public CopyOfBuilder status(String status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder orderDetails(String orderDetails) {
      return (CopyOfBuilder) super.orderDetails(orderDetails);
    }
    
    @Override
     public CopyOfBuilder clientDetails(String clientDetails) {
      return (CopyOfBuilder) super.clientDetails(clientDetails);
    }
  }
  

  public static class OrdersIdentifier extends ModelIdentifier<Orders> {
    private static final long serialVersionUID = 1L;
    public OrdersIdentifier(String id) {
      super(id);
    }
  }
  
}
