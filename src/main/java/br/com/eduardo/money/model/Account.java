package br.com.eduardo.money.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "accounts")
@TypeAlias("account")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Account {

    @Id
    private ObjectId id;
    @NonNull
    private String name;
    private String details;
    @NonNull
    private Double balance;

    @CreatedDate
    private Date created;
    @LastModifiedDate
    private Date lastModified;
    @Version
    private int version;

}
