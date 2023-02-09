package LDUBGD.DSNS.model;

/**
 * Вирахувати параметри для запиту JPEG від GeoServer
 */
public interface IRegionInfo {
    String getBbox();
    String getFid();

    public static double calcRatio(String bbox){
        String[] bboxArr = bbox.split(",");
        double w = Double.parseDouble(bboxArr[2])-Double.parseDouble(bboxArr[0]);
        double h = Double.parseDouble(bboxArr[3])-Double.parseDouble(bboxArr[1]);
        return w/h;
    }
}
