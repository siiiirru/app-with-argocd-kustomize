# SealedSecret 사용 가이드

## 1. SealedSecret Controller 설치
```bash
kubectl apply -f https://github.com/bitnami-labs/sealed-secrets/releases/download/v0.18.0/controller.yaml
```

## 2. kubeseal CLI 설치
```bash
# Windows (Chocolatey)
choco install kubeseal

# 또는 직접 다운로드
# https://github.com/bitnami-labs/sealed-secrets/releases
```

## 3. 실제 암호화된 시크릿 생성

### 데이터베이스 자격 증명 암호화:
```bash
# 데이터베이스 이름 암호화
echo -n "myappdb" | kubeseal --raw --from-file=/dev/stdin --name=mysql-app-secret --namespace=default

# 사용자명 암호화  
echo -n "myuser" | kubeseal --raw --from-file=/dev/stdin --name=mysql-app-secret --namespace=default

# 패스워드 암호화 (실제 보안 패스워드 사용)
echo -n "your-secure-password-here" | kubeseal --raw --from-file=/dev/stdin --name=mysql-app-secret --namespace=default
```

## 4. mysql-app-sealed-secret.yaml 업데이트
위 명령어로 생성된 암호화된 값들을 `mysql-app-sealed-secret.yaml` 파일의 PLACEHOLDER 부분에 교체하세요.

## 5. 보안 주의사항
- 실제 패스워드는 절대 Git에 커밋하지 마세요
- SealedSecret의 암호화된 값만 Git에 저장하세요
- 클러스터별로 다른 암호화 키를 사용하므로 환경별로 다시 암호화해야 합니다