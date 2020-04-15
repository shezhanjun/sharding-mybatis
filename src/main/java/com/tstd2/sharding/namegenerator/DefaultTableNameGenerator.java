package com.tstd2.sharding.namegenerator;

/**
 * 默认的表名称处理器实现。
 */
public class DefaultTableNameGenerator implements TableNameGenerator {

    @Override
    public String generate(String tablePrefix, int shardingTableNo, int shardingTableCount) {
        /*
         * 比如：
		 * 表前缀为     user_
		 * 分表号为     15
		 * 分表总数为 2048
		 * 那么实际表名为 user_0015
		 */
        // 根据分表总数算出表后缀宽度。 2014=4
        String tableSuffix = this.generateRealTableNo(shardingTableCount, shardingTableNo);
        StringBuilder builder = new StringBuilder(tablePrefix);
        return builder.append(tableSuffix).toString();
    }

    public String generateRealTableNo(int shardingTableCount, int shardingTableNo) {
        // 根据分表总数算出表后缀宽度。 2014=4
        int suffixWidth = (shardingTableCount + "").length();
        String tableSuffix = String.format("%0" + suffixWidth + "d", shardingTableNo);
        return tableSuffix;
    }

}
