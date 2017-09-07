package com.micropower.manager.common.util.excel;

/**
 * cell附属属性
 * @author yuhuafeng
 *
 */
public class CellInfo {
		
		/**
		 * cell列号
		 */
		private	int index;
		
		/**
		 * 取值的方法名称
		 */
		private String method;
		
		/**
		 * date类型格式化方式
		 */
		private String sdf;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public String getSdf() {
			return sdf;
		}

		public void setSdf(String sdf) {
			this.sdf = sdf;
		}
}
