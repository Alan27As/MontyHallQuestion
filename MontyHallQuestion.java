package GitHub;

import java.util.Random;

public class MontyHallQuestion {
	public static void main(String[] args) {
		Random random = new Random();
		int gameCount = 0;
		int playNumbers = 100000; // ゲーム回数
		int changeGetCar = 0;
		int notChangeGetCar = 0;
		System.out.println(playNumbers + " 回検証します。");

		while (gameCount < playNumbers) {
			int newCar = random.nextInt(3); // どのドアに新車が入っているかを決定

			int playerFirstChoice = random.nextInt(3); // プレイヤーがドアを一つ選択。まだ開けない。

			int montyOpen = 0;
			do {
				montyOpen = random.nextInt(3); // モンティがプレイヤーが選んでいない『ヤギ』のドアを開ける。
			} while (montyOpen == newCar || montyOpen == playerFirstChoice);

			int changeDoor = 0;
			do {
				changeDoor = random.nextInt(3); // モンティがドアを開けた後にプレイヤーが開けるドアを変えた場合のチョイス
			} while (changeDoor == montyOpen || changeDoor == playerFirstChoice);

			if (changeDoor == newCar) {
				changeGetCar++;
			} else if (playerFirstChoice == newCar) { // モンティがドアを開けた後にプレイヤーがドアを変えずにそのまま開けた場合のカウント
				notChangeGetCar++;
			}

			gameCount++;
		}
		System.out.println("ドアを変えた時の勝利回数： " + changeGetCar + "回");
		System.out.println("ドアを変えなかった時の勝利回数： " + notChangeGetCar + "回");
	}
}
