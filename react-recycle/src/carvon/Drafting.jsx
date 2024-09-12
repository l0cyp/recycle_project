import React, { useEffect, useState } from 'react';
import styles from '../styles/Drafting.module.css';

const Drafting = () => {
  const [companyData, setCompanyData] = useState([]);

  const fetchCompanyData = async () => {
    try {
      const response = await fetch('http://localhost:8080/carvon/companyList');
      const data = await response.json();
      setCompanyData(data); // 응답 데이터를 상태로 저장
    } catch (error) {
      console.error('Error fetching data:', error); // 에러 처리
    }
  };

  useEffect(() => {
    fetchCompanyData(); // 컴포넌트가 처음 렌더링될 때 데이터 요청
  }, []);

  const cardData = [
    {
      icon: 'path/to/icon1.png',
      title: '참여대상',
      description: '일상생활 속에서 친환경 활동을 실천하는 국민',
    },
    {
      icon: 'path/to/icon2.png',
      title: '참여방법',
      description: '탄소중립포인트 녹색생활 실천 누리집 회원가입을 통한 참여',
    },
    {
      icon: 'path/to/icon3.png',
      title: '실천항목',
      description: '전자영수증 발급, 텀블러/다회용컵 이용, 의류/장난감 반납, 리필스테이션 이용 등 다양한 실천항목',
    },
    {
      icon: 'path/to/icon4.png',
      title: '참여혜택',
      description: '현금, 참여기업/기부단체의 포인트 제공',
    },
  ];

  const InfoCard = ({ icon, title, description }) => {
    return (
      <div className={styles.card}>
        <img src={icon} alt={title} className={styles.icon} />
        <h3 className={styles.title}>{title}</h3>
        <p className={styles.description}>{description}</p>
      </div>
    );
  };

  return (
    <div>
      <h2 className={styles.header}>탄소중립포인트 녹색생활 실천이란?</h2>
      <p className={styles.subHeader}>
        일반국민의 탄소중립 생활 실천문화 확산을 위하여 다양한 민간기업의 친환경활동 이용 시 이용실적에 따라 인센티브를 지원하는 제도
      </p>
      <div className={styles.grid}>
        {cardData.map((card, index) => (
          <InfoCard key={index} icon={card.icon} title={card.title} description={card.description} />
        ))}
      </div>
      <div className={styles.imgBox}>
        <img src='/img/about_img.png' alt="About" />
      </div>
      <div className={styles.buttonContainer}>
        <div className={styles.button}>
          참여업체
          <span className={styles.buttonDesc}>참여 정보 제공 (→한국환경공단)</span>
        </div>
        <div className={styles.button}>
          한국환경공단
          <span className={styles.buttonDesc}>정산 및 지급</span>
        </div>
        <div className={styles.button}>
          참여자
          <span className={styles.buttonDesc}>인센티브 수령</span>
        </div>
      </div>
    </div>
  );
};

export default Drafting;
