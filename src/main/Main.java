package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args){
		//������Ϸ����Դ
		GameDto dto=new GameDto();
		//������Ϸ�߼��飨������Ϸ����Դ��
		GameService service=new GameService(dto);
		//������Ϸ���
		JPanelGame panel=new JPanelGame(dto);
		//������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl=new GameControl(panel,service);
		//������ҿ�������������Ϸ��������
		PlayerControl control=new PlayerControl(gameControl);
		//��װ��ҿ�����
		panel.setGameControl(control);
		//������Ϸ���ڣ���װ��Ϸ��壩
		JFrameGame frame=new JFrameGame(panel);
	}
}
