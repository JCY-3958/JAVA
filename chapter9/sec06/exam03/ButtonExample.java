package chapter9.sec06.exam03;

public class ButtonExample {

	public static void main(String[] args) {
		// 버튼 객체 생성
		Button btnOk = new Button();

		// 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스
		class OkListener implements Button.ClickListener {

			@Override
			public void onClick() {
				System.out.println("ok 버튼 클릭");
			}
		}

		// ok버튼 객체에 ClickListener 구현 객체 주입
		btnOk.setClickListener(new OkListener());

		// ok버튼 누르기
		btnOk.click();

		// ---------------------------------------------------------

		// cancel 버튼 객체 생성
		Button btnCancel = new Button();

		// Cancel 버튼 클릭 이벤트 처리 ClickListener 구현 클래스
		class CancelListener implements Button.ClickListener {

			@Override
			public void onClick() {
				System.out.println("Cancel 버튼 클릭");
			}
		}

		// cancel버튼 객체에 ClickListener 구현 객체 주입
		btnCancel.setClickListener(new CancelListener());

		// cancel버튼 누르기
		btnCancel.click();
	}

}
