find  . -name  '*.classpath' -type  f -print -exec  rm -rf  {} \;  
find  . -name  '*.springBeans' -type  f -print -exec  rm -rf  {} \;  
find  . -name  '*.settings' -type d -print -exec  rm -rf  {} \;  
find  . -name  'target' -type d -print -exec  rm -rf  {} \;  
find  . -name  '*.project' -type  f -print -exec  rm -rf  {} \;  
