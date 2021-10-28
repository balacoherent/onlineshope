package com.example.E_commerce.Entity_or_Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE User SET is_delete =1 WHERE user_id= ?")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "is_active", columnDefinition = "integer default 0")
    private int isActive =0;

    @Column(name = "is_delete", columnDefinition = "integer default 0")
    private int isDelete =0;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
/*    @JoinTable(name = "userrole",
            joinColumns = {@JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_role_id", referencedColumnName = "id")})*/
    private List<Role> listofrole;

    public  User(User user)
    {
        this.userId = user.getUserId();
        this.listofrole = user.getListofrole();
        this.userName = user.getUserName();
    }


}
