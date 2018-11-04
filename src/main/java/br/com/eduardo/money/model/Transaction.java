package br.com.eduardo.money.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transactions")
@TypeAlias("transaction")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

@CompoundIndexes({
        @CompoundIndex(def = "{'from':1, 'date':1}", name = "from_date")
})

public class Transaction {

    @Id
    private ObjectId id;
    @NonNull
    private Date date;
    @NonNull
    private String payee;
    @NonNull
    private String category;
    private String memo;
    private Double inflow;
    private Double outflow;
    private boolean cleared;
    @DBRef
    @NonNull
    private Account from;

    @CreatedDate
    private Date created;
    @LastModifiedDate
    private Date lastModified;
    @Version
    private int version;


}
