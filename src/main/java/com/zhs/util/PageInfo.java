package com.zhs.util;

import lombok.Data;

import javax.jnlp.IntegrationService;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/21 8:49
 * 描述:分页实体类
 **/
@Data
public class PageInfo <T>{

    private Integer  totalRecords;//总页数
    private Integer totalPages;//总页数
    private Integer pageSize;//每页显示数
    private Integer  currentPage;//当前页数
    private List<T> list;//数据


    public PageInfo(){
               this.currentPage=1;
               this.pageSize=10;
    }
    //分页初始化
    public PageInfo(int totalRecords,int currentPage,int pageSize,List<T> list){
         this.totalRecords=totalRecords;
         //总记录数%每页显示数 ==0？总记录数/每页显示数:总记录数/每页显示数+1
         this.totalPages=(int)Math.ceil(totalRecords/(double)pageSize);
         this.currentPage=currentPage;
         this.pageSize=pageSize;
         this.list=list;
    }
    //首页
        public int getFirstPage(){
                return 1;
        }

    //尾页
    public int getLastPage(){
        return  totalPages;
    }
    //定义上一页
    public int getPrePage(){
        return  currentPage-1<1?1:currentPage-1;
    }
    //定义下一页
    public int getNextPage(){
        return  currentPage+1>totalPages?currentPage:currentPage+1;
    }
}
