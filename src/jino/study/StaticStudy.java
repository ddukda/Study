package jino.study;

public class StaticStudy {
	static int a=0; //��������a�� �ʱⰪ�� 0�̴�.
	int b=0; //�Ϲݺ���a�� �ʱⰪ�� 0�̴�.

	static
	{
		StaticStudy.a=1;
		StaticStudy.moveA(5); ////static�� �ƴ� �Ϲݺ����� �޼ҵ�� �ȿ��� ���Ұ���
		System.out.println("ó���� ��ġ�� static{ }�Դϴ�");
	}

	static void moveA(int x)
	{
		a=a+x;
		System.out.println("moveA �޼ҵ��Դϴ�");
	}

	void moveB(int y)
	{
		b=b+y;
		System.out.println("moveB �޼ҵ��Դϴ�");
	}

	static
	{
		StaticStudy.a=2;
		StaticStudy.moveA(8); ////static�� �ƴ� �Ϲݺ����� �޼ҵ�� �ȿ��� ���Ұ���
		System.out.println("���� ��ġ�� static{ }�Դϴ�");
	}

	public static void main(String[] args)
	{
		StaticStudy.a=10; //���������� ��ü�������� �ٷ� ��밡��
		a=10; //StaticStudy. ��������
		System.out.println("> " + StaticStudy.a);
		System.out.println(a); //StaticStudy. ��������
		StaticStudy.moveA(1); //�����޼ҵ嵵 ��ü�������� �ٷ� ��밡��
		moveA(1); //StaticStudy. ��������
		System.out.println(StaticStudy.a);
		System.out.println(a); //StaticStudy. ��������

		System.out.println("=====1=====");

		StaticStudy t=new StaticStudy();
		t.b=10; //�Ϲݺ����� ���Ͱ��� ��ü�����Ŀ� ��밡��
		System.out.println(t.b);
		t.moveB(1); //�Ϲݸ޼ҵ嵵 ��ü�����Ŀ� ��밡��
		System.out.println(t.b);

		System.out.println("=====2=====");

		StaticStudy t1=new StaticStudy(); //��ü������ ���� t1�� �ν��Ͻ��� ����.
		StaticStudy t2=new StaticStudy(); //��ü������ ���� t2�� �ν��Ͻ��� ����.

		System.out.println(t1.a); //��������a�� �ڵ����� ó���� �ѹ��� �����ȴ�.
		System.out.println(t2.a);
		System.out.println(t1.b); //�Ϲݺ���b�� ��ü������ �Ź� ���� �����ȴ�.
		System.out.println(t2.b);

		System.out.println("=====3=====");

		t1.a=111;

		System.out.println(t1.a);
		System.out.println(t2.a); //��������a�� ��� ��ü�� ���� �����Ѵ�.

		t1.b=222;

		System.out.println(t1.b);
		System.out.println(t2.b); //�Ϲݺ���b�� ��ü�鳢�� ���� �������� �ʴ´�.
	}
}
