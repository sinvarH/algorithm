package DB;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
//        if (args.length<1){
//            System.out.println("arguments annotated classes");
//            System.exit(0);
//        }
//        for (String className:args){
            String className = Member.class.getName();
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable==null){
                System.out.println("no DBTabel annotations i class"+className);
//                continue;
            }
            String tableName = dbTable.name();
            //如果名字为空，使用类名
            if (tableName.length()<1)
                tableName = cl.getName().toUpperCase();

            List<String> columnDefs = new ArrayList<>();
            for (Field field:cl.getDeclaredFields()){
                String columnName = null;
                Annotation [] annotations = field.getDeclaredAnnotations();
                if (annotations.length<1){
                    continue; //not a db table column;
                }
                if (annotations[0] instanceof SQLInteger){
                    SQLInteger sInt = (SQLInteger) annotations[0];
                    //没有指定column名的话直接使用field名字
                    if (sInt.name().length()<1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName+ " INT"+getConstraints(sInt.contrains()));
                }

                if (annotations[0] instanceof SQLString){
                    SQLString sString = (SQLString) annotations[0];
                    //没有指定column名的话直接使用field名字
                    if (sString.name().length()<1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName+ " VARCHAR("+sString.value()+")"+getConstraints(sString.contrains()));
                }
            }
            StringBuilder sb = new StringBuilder("CREATE TABLE "+ tableName+"(");
            for (String columnDef:columnDefs){
                sb.append("\n    "+columnDef+",");
            }
            String tableCreate = sb.substring(0,sb.length()-1)+");";
            System.out.println("table sql for "+ className+"is \n"+tableCreate);
        }


    private static String getConstraints(Constrains constrains){
        StringBuilder sb = new StringBuilder();
        if (!constrains.allowNull()){
            sb.append(" NOT NULL");
        }
        if (constrains.primaryKey()){
            sb.append(" PRIMARY KEY");
        }
        if (constrains.unique()){
            sb.append(" UNIQUE");
        }
        return sb.toString();
    }
}
