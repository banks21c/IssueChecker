package com.goodbyenote.bapdosaptlweb.common.model;

public class GlobalStatic {

/*	CC00001801	(일반) 동
	CC00002700	배달관리-수거메뉴보이기
	CC00002701	예
	CC00002702	아니오
	CC00002800	배달고객 전화 수신시 고객정보 바탕화면에 보이기
	CC00002801	예
	CC00002802	아니오
	CC00001800	동, 랜드마크 여부
	CC00001802	(일반) 랜드마크
	CC00000100	사용자구분
	CC00000101	가게사장
	CC00000102	가게직원
	CC00000103	협회직원
	CC00000104	창업희망자
	CC00000105	전문가
	CC00000200	세금계산서유형
	CC00000201	세금계산서매출
	CC00000202	과세매입전자세금계산서
	CC00000203	과세매입일반세금계산서
	CC00000204	면세매입전자세금계산서
	CC00000205	면세매입일반세금계산서
	CC00000206	기타매입
	CC00000300	결제수단유형
	CC00000301	현금
	CC00000302	카드
	CC00000303	외상
	CC00000400	근로형태유형
	CC00000401	정직원
	CC00000402	임시직
	CC00000403	파트타임
	CC00000500	임금유형
	CC00000501	월급
	CC00000502	일급
	CC00000503	시급
	CC00000600	지출자료유형
	CC00000601	신용카드
	CC00000602	자료나중받음
	CC00000603	현금영수증
	CC00000604	기타영수증
	CC00000605	(세금)계산서
	CC00000700	수입자료유형
	CC00000701	발행없음
	CC00000702	나중발행
	CC00000703	(세금)계산서
	CC00000800	배달이력유형
	CC00000801	시작금액
	CC00000802	배달
	CC00000803	반환
	CC00000900	배달상태
	CC00000901	대기
	CC00000902	배달중
	CC00000903	완료
	CC00002500	전국랭킹-평수기준
	CC00002501	3평 이하
	CC00002502	4~5평
	CC00002503	6~10평
	CC00002504	11~15평
	CC00002505	16~20평
	CC00002506	20~25평
	CC00002507	26~30평
	CC00002508	31~40평
	CC00002509	41~50평
	CC00002510	51~70평
	CC00002511	71~100평
	CC00002512	초대형
	CC00002600	전국랭킹-임차료 기준
	CC00002601	30만 이하
	CC00002602	40~50
	CC00002603	60~70
	CC00002604	80~100
	CC00002605	110~150
	CC00002606	160~200
	CC00002607	210~300
	CC00002608	310~400
	CC00002609	410~500
	CC00002610	510~700
	CC00002611	710~900
	CC00002612	초대형
	CC00001000	메모유형
	CC00001001	메모
	CC00001002	예약
	CC00001003	예약해지
	CC00001004	고객요구
	CC00001005	합석
	CC00001006	연결
	CC00001007	연결해제
	CC00001008	주문
	CC00001009	포장
	CC00001010	배달
	CC00001011	포장판매
	CC00001012	손실
	CC00001013	배달실패
	CC00001014	식권
	CC00001100	포인트이력유형
	CC00001101	주문적립
	CC00001102	배달적립
	CC00001103	주문사용
	CC00001104	배달사용
	CC00001300	매상구분
	CC00001301	매장주문
	CC00001302	배달주문
	CC00001303	식권판매
	CC00001400	현금확인상태구분
	CC00001401	미확인
	CC00001402	직원확인
	CC00001403	사장확인
	CC00001404	직원후사장확인
	CC00001500	예약상태
	CC00001501	예약완료
	CC00001502	예약취소
	CC00001503	주문(예약종료)
	CC00001600	집합일반여부
	CC00001601	집합
	CC00001602	일반
	CC00001700	지역건물유형
	CC00001701	(집합) APT
	CC00001702	(집합) 빌딩
	CC00001703	(집합) 상가
	CC00001704	(집합) 기타
	CC00001900	비용
	CC00001901	음식재료비
	CC00001902	음식부재료
	CC00001903	주류음료
	CC00001904	소모품비
	CC00001905	전기수도가스
	CC00001906	인건비
	CC00001907	복리후생비
	CC00001908	세금공과금
	CC00001909	지급수수료
	CC00001910	임차
	CC00001911	통신비
	CC00001912	광고비
	CC00001913	차량유지비
	CC00001914	기타경비
	CC00002000	음식재료비
	CC00002001	쌀잡곡
	CC00002002	밀가루
	CC00002003	농산물기타
	CC00002004	축산물
	CC00002005	할어
	CC00002006	수산물기타
	CC00002007	햄등냉장식품
	CC00002008	냉동식품
	CC00002009	라면및면류
	CC00002010	적요 직접입력
	CC00002100	매장/배달/포장 금액유형
	CC00002101	같음
	CC00002102	다름
	CC00002200	매장/배달/포장 포인트/할인율유형
	CC00002201	같음
	CC00002202	다름
	CC00002300	포인트,할인율 구분
	CC00002301	포인트
	CC00002302	할인율
	CC00002400	점심시간 점심특선메뉴 앞으로
	CC00002401	예
	CC00002402	아니오
	CC00000804	외상수금*/
	
	public static final String MEMO_TYPE = "CC00001000";	//메모유형
	public static final String MEMO_TYPE_MEMO = "CC00001001";	//메모
	public static final String MEMO_TYPE_RESERVATION = "CC00001002";	//예약
	public static final String MEMO_TYPE_RESERVATION_CANCEL = "CC00001003";	//예약해지
	public static final String MEMO_TYPE_CUSTOMER_REQUEST = "CC00001004";	//고객요구
	public static final String MEMO_TYPE_SHARE = "CC00001005";	//합석
	public static final String MEMO_TYPE_CONNECT = "CC00001006";	//연결
	public static final String MEMO_TYPE_CONNECT_CANCEL = "CC00001007";	//연결해제
	public static final String MEMO_TYPE_ORDER = "CC00001008";	//주문
	public static final String MEMO_TYPE_TAKEOUT = "CC00001009";	//포장
	public static final String MEMO_TYPE_DELIVERY = "CC00001010";	//배달
	public static final String MEMO_TYPE_TAKEOUT_SALES = "CC00001011";	//포장판매
	public static final String MEMO_TYPE_LOSS = "CC00001012";	//손실
	public static final String MEMO_TYPE_DELIVERY_FAIL = "CC00001013";	//배달실패
	public static final String MEMO_TYPE_TICKET = "CC00001014";	//식권
}
