package com.griftt.server.algorithm.categorytree;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private Integer parentId;

    public Category(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
    public Category() {

    }

    public static void main(String[] args) {
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
       for (int a=1;a<4;a++){
           categoryDtos.add(new CategoryDto(a,"a"+a,0));
           for (int b=1;b<4;b++){
               categoryDtos.add(new CategoryDto(a+b,"a"+a+""+b,a));
               for (int c=2;c<5;c++){
                   categoryDtos.add(new CategoryDto(a+b+c,"a"+a+""+b,b+a));
               }
           }
       }
        System.out.println(categoryDtos);
        Category category = new Category();
        List<CategoryDto> category1 = category.getCategory(categoryDtos);
        System.err.println(JSONUtil.toJsonPrettyStr(category1));
    }
    public List<CategoryDto> getCategory(List<CategoryDto> list){

        //存放顶级父类
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
        //所有类型
        List<CategoryDto> arrayList = list;
        Iterator<CategoryDto> iterator = arrayList.iterator();
        //获取顶级父类
        while (iterator.hasNext()){
            CategoryDto next = iterator.next();
            if (next.getParentId()==0){
                categoryDtos.add(next);
                iterator.remove();
            }
        }
        Iterator<CategoryDto> sonite = arrayList.iterator();
        if(categoryDtos.size()>0&&sonite.hasNext()){
            //递归子类
            getChildCategory(categoryDtos,arrayList);
        }
        return categoryDtos;
    }

    public void getChildCategory(List<CategoryDto> topList,List<CategoryDto> restList){
        for (CategoryDto top:topList) {
            Integer topId = top.getId();
            Iterator<CategoryDto> iterator = restList.iterator();
            ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
            while (iterator.hasNext()){
                //判断是否为其子类
                CategoryDto next = iterator.next();
                if (topId.equals(next.getParentId())){
                    categoryDtos.add(next);
                    iterator.remove();
                }
            }
            top.setList(categoryDtos);
            //如果子类存在，则继续递归
            Iterator<CategoryDto> sonIte = restList.iterator();
            if(categoryDtos.size()>0&&sonIte.hasNext()){
                getChildCategory(categoryDtos,restList);
            }
        }

    }

}
