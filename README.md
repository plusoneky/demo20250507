"# demo20250507" 

1¡¢ÏÈµÇÂ¼github´´½¨²Ö¿â£ºdemo20250507

2¡¢cd demo20250507
git config --global user.email "plusone@163.com"
git config --global user.name "plusoneky"

echo "# demo20250507" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/plusoneky/demo20250507.git
git push -u origin main

git add .
git commit -m "src commit"
git push
