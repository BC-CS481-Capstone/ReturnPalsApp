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

/** This is an auto generated class representing the MailingList type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "MailingLists", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class MailingList implements Model {
  public static final QueryField ID = field("MailingList", "id");
  public static final QueryField FULL_NAME = field("MailingList", "full_name");
  public static final QueryField POSTAL_CODE = field("MailingList", "postal_code");
  public static final QueryField EMAIL = field("MailingList", "email");
  public static final QueryField MESSAGE = field("MailingList", "message");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String full_name;
  private final @ModelField(targetType="String") String postal_code;
  private final @ModelField(targetType="String") String email;
  private final @ModelField(targetType="String") String message;
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
  
  public String getFullName() {
      return full_name;
  }
  
  public String getPostalCode() {
      return postal_code;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getMessage() {
      return message;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private MailingList(String id, String full_name, String postal_code, String email, String message) {
    this.id = id;
    this.full_name = full_name;
    this.postal_code = postal_code;
    this.email = email;
    this.message = message;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      MailingList mailingList = (MailingList) obj;
      return ObjectsCompat.equals(getId(), mailingList.getId()) &&
              ObjectsCompat.equals(getFullName(), mailingList.getFullName()) &&
              ObjectsCompat.equals(getPostalCode(), mailingList.getPostalCode()) &&
              ObjectsCompat.equals(getEmail(), mailingList.getEmail()) &&
              ObjectsCompat.equals(getMessage(), mailingList.getMessage()) &&
              ObjectsCompat.equals(getCreatedAt(), mailingList.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), mailingList.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFullName())
      .append(getPostalCode())
      .append(getEmail())
      .append(getMessage())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("MailingList {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("full_name=" + String.valueOf(getFullName()) + ", ")
      .append("postal_code=" + String.valueOf(getPostalCode()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("message=" + String.valueOf(getMessage()) + ", ")
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
  public static MailingList justId(String id) {
    return new MailingList(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      full_name,
      postal_code,
      email,
      message);
  }
  public interface BuildStep {
    MailingList build();
    BuildStep id(String id);
    BuildStep fullName(String fullName);
    BuildStep postalCode(String postalCode);
    BuildStep email(String email);
    BuildStep message(String message);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String full_name;
    private String postal_code;
    private String email;
    private String message;
    public Builder() {
      
    }
    
    private Builder(String id, String full_name, String postal_code, String email, String message) {
      this.id = id;
      this.full_name = full_name;
      this.postal_code = postal_code;
      this.email = email;
      this.message = message;
    }
    
    @Override
     public MailingList build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new MailingList(
          id,
          full_name,
          postal_code,
          email,
          message);
    }
    
    @Override
     public BuildStep fullName(String fullName) {
        this.full_name = fullName;
        return this;
    }
    
    @Override
     public BuildStep postalCode(String postalCode) {
        this.postal_code = postalCode;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep message(String message) {
        this.message = message;
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
    private CopyOfBuilder(String id, String fullName, String postalCode, String email, String message) {
      super(id, full_name, postal_code, email, message);
      
    }
    
    @Override
     public CopyOfBuilder fullName(String fullName) {
      return (CopyOfBuilder) super.fullName(fullName);
    }
    
    @Override
     public CopyOfBuilder postalCode(String postalCode) {
      return (CopyOfBuilder) super.postalCode(postalCode);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder message(String message) {
      return (CopyOfBuilder) super.message(message);
    }
  }
  

  public static class MailingListIdentifier extends ModelIdentifier<MailingList> {
    private static final long serialVersionUID = 1L;
    public MailingListIdentifier(String id) {
      super(id);
    }
  }
  
}
