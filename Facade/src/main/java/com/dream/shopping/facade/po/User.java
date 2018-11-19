package com.dream.shopping.facade.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 16:04
 */
@Entity
@Table
public class User implements Serializable {

    private static final long serialVersionUID = -352894862336629248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uId;



}