package br.com.eduardo.money.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
@TypeAlias("user")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    @Indexed(unique = true)
    private String email;
    @NonNull
    private String hashedPassword;
    @DBRef
    private List<Account> accounts;

    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
    @Version
    private int version;

}
