import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class main {
	static final int AllDayAdultTK = 62000;
	static final int ParkDayAdultTK = 59000;
	static final int AllDayTeenTK = 54000;
	static final int ParkDayTeenTK = 52000;
	static final int AllDayChildTK = 47000;
	static final int ParkDayChildTK = 46000;
	static final int AllDayBabyTK = 15000;
	static final int ParkDayBabyTK = 15000;
	static final int AllDayOlderTK = 15000;
	static final int ParkDayOlderTK = 15000;
	static final int AllAfter4AdultTK = 50000;
	static final int ParkAfter4AdultTK = 47000;
	static final int AllAfter4TeenTK = 43000;
	static final int ParkAfter4TeenTK = 41000;
	static final int AllAfter4ChildTK = 36000;
	static final int ParkAfter4ChildTK = 35000;
	static final int AllAfter4BabyTK = 15000;
	static final int ParkAfter4BabyTK = 15000;
	static final int AllAfter4OlderTK = 15000;
	static final int ParkAfter4OlderTK = 15000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[][] orderList = new int[20][20];
		int inputType = 0;
		int inputTicket =  0;
		int inputRegisterNum = 0;
		int inputRegisterNum2 = 0;
		int inputbenefit = 0;
		int price = 0;
		int money = 0;
		int extend;
		int totalmoney = 0;
		int numberofticket = 1;
		int basicFeeType = 0;
		int orderCount = 0;
		int addTicket = 0;
		int today;
		int year;
		int month;
		int day;
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdt = new SimpleDateFormat("YYMMdd");
	    today = Integer.parseInt(sdt.format(cal.getTime()));
	    System.out.println(today);
	    year = 2000 + today/10000;
	    month = today%10000/100;
	    day = today%100;
		do {
			money = 0;			
			System.out.printf("**********************************************************");
			System.out.printf("이용권 종류를 선택하세요.\n");
			System.out.printf("1. 종합이용권(롯데월드 + 민속박물관)\n");
			System.out.printf("2. 파크이용권(롯데월드)\n");
			inputType = scanner.nextInt();
			System.out.printf("\n");
			System.out.printf("권종을 선택하세요.\n");
			System.out.printf("1. 주간권\n");
			System.out.printf("2. After4\n");
			inputTicket = scanner.nextInt();
			System.out.printf("\n");
			System.out.printf("주민등록번호앞자리를 입력하세요.\n");
			inputRegisterNum = scanner.nextInt();
			System.out.printf("\n");
			System.out.printf("주민등록번호 뒷자리 첫번째숫자를 입력하세요.\n");
			inputRegisterNum2 = scanner.nextInt();
			System.out.printf("\n");
			System.out.printf("우대사항을 선택하세요.\n");
			System.out.printf("1. 없음 (나이 우대는 자동처리)\n");
			System.out.printf("2. 장애인\n");
			System.out.printf("3. 국가유공자\n");
			System.out.printf("4. 휴가장병\n");
			System.out.printf("5. 임산부\n");
			System.out.printf("6. 다둥이 행복카드\n");
			inputbenefit = scanner.nextInt();
			System.out.printf("몇장을 선택하시겠습니까?.\n");
			addTicket = scanner.nextInt();
			System.out.printf("\n\n");
			int RealAge = 0;

			// 만 나이 계산
			if (inputRegisterNum2 == 1 || inputRegisterNum2 == 2) {
				if (inputRegisterNum % 10000  > today%10000) {
					RealAge = year - (1900 + inputRegisterNum / 10000) - 1;
				} else if (inputRegisterNum % 10000  < today%10000) {
					RealAge = year - (1900 + inputRegisterNum / 10000);
				}
			} else if (inputRegisterNum2 == 3 || inputRegisterNum2 == 4) {
				if (inputRegisterNum % 10000  > today%10000) {
					RealAge = year - (2000 + inputRegisterNum / 10000) - 1;
				} else if (inputRegisterNum % 10000  < today%10000) {
					RealAge = year - (2000 + inputRegisterNum / 10000);
				}
			} // ReaLAge 구해짐

			if (RealAge > 65) { // 노인
				basicFeeType = 1;
			} else if (RealAge < 65 && RealAge > 18) { // 성인
				basicFeeType = 2;
			} else if (RealAge > 12 && RealAge < 19) { // 청소년
				basicFeeType = 3;
			} else if (RealAge > 3 && RealAge < 13) { // 어린아
				basicFeeType = 4;
			} else if (RealAge < 4) { // 아기
				basicFeeType = 5;
			}
			// 연령별 가격 책정
			if (inputType == 1) {
				if (inputTicket == 1) {
					if (RealAge > 65) { // 노인
						price = AllDayOlderTK;
					} else if (RealAge < 65 && RealAge > 18) { // 성인
						price = AllDayAdultTK;
					} else if (RealAge > 12 && RealAge < 19) { // 청소년
						price = AllDayTeenTK;
					} else if (RealAge > 3 && RealAge < 13) { // 어린아
						price = AllDayChildTK;
					} else if (RealAge < 4) { // 아기
						price = AllDayBabyTK;
					}
				}
				if (inputTicket == 2) {
					if (RealAge > 65) { // 노인
						price = ParkDayOlderTK;
					} else if (RealAge < 65 && RealAge > 18) { // 성인
						price = ParkDayAdultTK;
					} else if (RealAge > 12 && RealAge < 19) { // 청소년
						price = ParkDayTeenTK;
					} else if (RealAge > 3 && RealAge < 13) { // 어린아
						price = ParkDayChildTK;
					} else if (RealAge < 4) { // 아기
						price = ParkDayBabyTK;
					}
				}
				// 가격책정에 할인 적용
				switch (inputbenefit) {
				case 1: {
					money = price;
					break;
				}
				case 2: {
					money = price * 5 / 10;
					break;
				}
				case 3: {
					money = price * 5 / 10;
					break;
				}
				case 4: {
					money = price * 49 / 100;
					break;
				}
				case 5: {
					money = price * 5 / 10;
					break;
				}
				case 6: {
					money = price * 70 / 100;
					break;
				}
				}
			} else if (inputType == 2) {
				if (inputTicket == 1) {
					if (RealAge > 65) { // 노인
						price = AllAfter4OlderTK;
					} else if (RealAge < 65 && RealAge > 18) { // 성인
						price = AllAfter4AdultTK;
					} else if (RealAge > 12 && RealAge < 19) { // 청소년
						price = AllAfter4TeenTK;
					} else if (RealAge > 3 && RealAge < 13) { // 어린아
						price = AllAfter4ChildTK;
					} else if (RealAge < 4) { // 아기
						price = AllAfter4BabyTK;
					}
				}
				if (inputTicket == 2) {
					if (RealAge > 65) { // 노인
						price = ParkAfter4OlderTK;
					} else if (RealAge < 65 && RealAge > 18) { // 성인
						price = ParkAfter4AdultTK;
					} else if (RealAge > 12 && RealAge < 19) { // 청소년
						price = ParkAfter4TeenTK;
					} else if (RealAge > 3 && RealAge < 13) { // 어린아
						price = ParkAfter4ChildTK;
					} else if (RealAge < 4) { // 아기
						price = ParkAfter4BabyTK;
					}
				}
				switch (inputbenefit) {
				case 1: {
					money = price;
					break;
				}
				case 2: {
					money = price * 5 / 10;
					break;
				}
				case 3: {
					money = price * 5 / 10;
					break;
				}
				case 4: {
					money = price;
					System.out.printf("휴가장병 우대는 종합이용권만 할인됩니다\n");
					break;
				}
				case 5: {
					money = price;
					System.out.printf("임산부 우대는 종합이용권만 할인됩니다\n");
					break;
				}
				case 6: {
					money = price;
					System.out.printf("다둥이 행복카드 우대는 종합이용권만 할인됩니다\n");
					break;
				}
				}
			}
			
			if (price == AllDayOlderTK || price == ParkDayOlderTK || price == AllAfter4OlderTK
					|| price == ParkAfter4OlderTK) {
				money = price; // 노인 가격
				System.out.printf("티켓 금액은 %d원 입니다.\n\n", money);
			} else {
				System.out.printf("티켓 금액은 %d원 입니다.\n\n", money);
			}
			totalmoney += money;

			orderList[orderCount][0] = inputType; // 이용권종류
			orderList[orderCount][1] = inputTicket; // 이용권 옵션
			orderList[orderCount][2] = basicFeeType; // 나이별 권종
			orderList[orderCount][3] = numberofticket; // 몇장
			orderList[orderCount][4] = money; // 가격
			orderList[orderCount][5] = inputbenefit; // 우대사항
			orderCount++;

			System.out.printf("계속 발권 하시겠습니까?\n");
			System.out.printf("티켓 발권 : 1\n");
			System.out.printf("종료 : 2\n");
			System.out.printf("처음으로 : 3\n");
			extend = scanner.nextInt();
			System.out.printf("%d", extend);
			System.out.printf("\n");

		} while (extend == 1);
		System.out.printf("\n\n*************************************** 결제 정보 *****************************************\n");
		System.out.printf("이용권 종류\t이용권 옵션\t나이별 권종\t가격\t\t우대사항\n");
		for (int i = 0; i < orderCount; i++) {
			switch (orderList[i][0]) {
			case 1: {
				System.out.printf("종합이용권\t\t");
				break;
			}
			case 2: {
				System.out.printf("파크이용권\t\t");
				break;
			}
			}
			switch (orderList[i][1]) {
			case 1: {
				System.out.printf("1Day\t\t");
				break;
			}
			case 2: {
				System.out.printf("After4\t\t");
				break;
			}
			}
			switch (orderList[i][2]) {
			case 1: {
				System.out.printf("노인\tt");
				break;
			}
			case 2: {
				System.out.printf("성인\t\t");
				break;
			}
			case 3: {
				System.out.printf("청소년\t\t");
				break;
			}
			case 4: {
				System.out.printf("어린이\t\t");
				break;
			}
			case 5: {
				System.out.printf("베이비\t\t");
				break;
			}

			}
			orderList[orderCount][3] = 1;
			orderList[orderCount][4] = money;
			System.out.printf("%d\t\t", orderList[i][4]);
			if (orderList[i][5] == 2) {
				System.out.printf("*장애인 우대\n");

			} else if (orderList[i][5] == 3) {
				System.out.printf("*국가유공자 우대\n");

			} else if (inputType == 1 && orderList[i][5] == 4) {
				System.out.printf("*휴가장병 우대\n");

			} else if (inputType == 1 && orderList[i][5] == 5) {
				System.out.printf("*임산부 우대\n");

			} else if (inputType == 1 && orderList[i][5] == 6) {
				System.out.printf("*다둥이 행복카드 우대\n");

			} else {
				System.out.printf("*우대사항 없음\n");

			}
		}
		System.out.printf("\n---------------------------------------------------------------------------\n");
		System.out.printf("결제 금액\t\t\t\t\t\t\t%d원\n\n", totalmoney);
	}

}
