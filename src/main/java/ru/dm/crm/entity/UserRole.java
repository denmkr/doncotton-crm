package ru.dm.crm.entity;

import javax.persistence.*;

/**
 * Created by denis on 31/03/2018.
 */
@Entity
@Table(name = "user_roles", schema = "public", catalog = "doncotton-crm")
public class UserRole {
    private int userRoleId;
    private int userId;
    private String authority;

    @Id
    @Column(name = "user_role_id")
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole that = (UserRole) o;

        if (userRoleId != that.userRoleId) return false;
        if (userId != that.userId) return false;
        if (authority != null ? !authority.equals(that.authority) : that.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + userId;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
