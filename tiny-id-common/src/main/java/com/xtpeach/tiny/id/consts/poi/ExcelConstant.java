package com.xtpeach.tiny.id.consts.poi;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.xtpeach.tiny.id.utils.poi.ExportStylerBorderUtil;

/**
 * easy poi excel 导出常量
 *
 * @author xtpeach
 */
public class ExcelConstant {

    public static ImportParams importParams = new ImportParams();

    public static ExportParams exportParams = new ExportParams();

    public static final String EXPORTED_FILE_NAME_HEADER = "Download-Filename";

    static {
        importParams.setTitleRows(0);
        importParams.setHeadRows(1);
        importParams.setNeedVerify(true);

        exportParams.setType(ExcelType.HSSF);
        exportParams.setStyle(ExportStylerBorderUtil.class);
    }

}
