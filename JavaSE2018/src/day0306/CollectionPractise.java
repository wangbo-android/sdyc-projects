package day0306;

import java.util.Collection;
import java.util.HashSet;

public class CollectionPractise {

	public static void main(String[] args) {
		
		Collection<String> books = new HashSet<String>();
		
		books.add("�����˸����ֿռ������");
		books.add("�Ĺ��������ڹ���Ȼ�������Ͽ���Ȼ���Ƽ�");
		books.add("�ֹ����ʽϸ߼��￴���ƿ���");
		
		books.forEach(obj -> System.out.println(obj));
	}

}
