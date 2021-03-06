package com.hacknet.wheelsy.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    private String name;

    @NotNull
    @Size(max = 30)
    private String lastname;

    @NotNull
    @Size(max = 30)
    private String username;

    @NotNull
    @Size(max=100)
    private String address;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 20)
    private String gender;

    @NotNull
    @Size(max = 20)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "maintenance_activity",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "entrepreneur_id")})
    private List<Entrepreneur> entrepreneurs;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "subscriptions",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "subscription_plan_id")})
    private List<SubscriptionPlan> subscriptionPlans;



    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Entrepreneur> getEntrepreneurs() {
        return entrepreneurs;
    }

    public User setEntrepreneurs(List<Entrepreneur> entrepreneurs) {
        this.entrepreneurs = entrepreneurs;
        return this;
    }


    public List<SubscriptionPlan> getSubscriptionPlans() {
        return subscriptionPlans;
    }

    public User setSubscriptionPlans(List<SubscriptionPlan> subscriptionPlans) {
        this.subscriptionPlans = subscriptionPlans;
        return this;
    }

    public boolean isSubscribeWith(SubscriptionPlan subscriptionPlan) {
        return this.getSubscriptionPlans().contains(subscriptionPlan);
    }

    public User SubscribeWith(SubscriptionPlan subscriptionPlan) {
        if(!this.isSubscribeWith(subscriptionPlan))
            this.getSubscriptionPlans().add(subscriptionPlan);
        return this;
    }

    public User UnsubscribeWith(SubscriptionPlan SubscriptionPlan) {
        if(this.isSubscribeWith(SubscriptionPlan))
            this.getSubscriptionPlans().remove(SubscriptionPlan);
        return this;
    }

    public boolean IsSignedWith(Entrepreneur entrepreneur) {
        return this.getEntrepreneurs().contains(entrepreneur);
    }

    public User SignedWith(Entrepreneur entrepreneur) {
        if(!this.IsSignedWith(entrepreneur))
            this.getEntrepreneurs().add(entrepreneur);
        return this;
    }

    public User UnsignedWith(Entrepreneur entrepreneur) {
        if(this.IsSignedWith(entrepreneur))
            this.getEntrepreneurs().remove(entrepreneur);
        return this;
    }

}
