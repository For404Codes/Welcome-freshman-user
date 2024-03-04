<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="account">
      <el-input v-model="dataForm.account" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="gender">
      <el-input v-model="dataForm.gender" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="对应属性表ID" prop="attributeId">
      <el-input v-model="dataForm.attributeId" placeholder="对应属性表ID"></el-input>
    </el-form-item>
    <el-form-item label="学号" prop="studentNumber">
      <el-input v-model="dataForm.studentNumber" placeholder="学号"></el-input>
    </el-form-item>
    <el-form-item label="生源地" prop="source">
      <el-input v-model="dataForm.source" placeholder="生源地"></el-input>
    </el-form-item>
    <el-form-item label="身份证号" prop="idNumber">
      <el-input v-model="dataForm.idNumber" placeholder="身份证号"></el-input>
    </el-form-item>
    <el-form-item label="学院ID" prop="collegeId">
      <el-input v-model="dataForm.collegeId" placeholder="学院ID"></el-input>
    </el-form-item>
    <el-form-item label="关键字设置" prop="preferences">
      <el-input v-model="dataForm.preferences" placeholder="关键字设置"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建者用户ID" prop="createdUser">
      <el-input v-model="dataForm.createdUser" placeholder="创建者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者用户ID" prop="updatedUser">
      <el-input v-model="dataForm.updatedUser" placeholder="更新者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="是否删除（1是，0否）" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除（1是，0否）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          userId: 0,
          account: '',
          password: '',
          email: '',
          gender: '',
          attributeId: '',
          studentNumber: '',
          source: '',
          idNumber: '',
          collegeId: '',
          preferences: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          account: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          attributeId: [
            { required: true, message: '对应属性表ID不能为空', trigger: 'blur' }
          ],
          studentNumber: [
            { required: true, message: '学号不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '生源地不能为空', trigger: 'blur' }
          ],
          idNumber: [
            { required: true, message: '身份证号不能为空', trigger: 'blur' }
          ],
          collegeId: [
            { required: true, message: '学院ID不能为空', trigger: 'blur' }
          ],
          preferences: [
            { required: true, message: '关键字设置不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createdUser: [
            { required: true, message: '创建者用户ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          updatedUser: [
            { required: true, message: '更新者用户ID不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除（1是，0否）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.userId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.userId) {
            this.$http({
              url: this.$http.adornUrl(`/user/users/info/${this.dataForm.userId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.account = data.users.account
                this.dataForm.password = data.users.password
                this.dataForm.email = data.users.email
                this.dataForm.gender = data.users.gender
                this.dataForm.attributeId = data.users.attributeId
                this.dataForm.studentNumber = data.users.studentNumber
                this.dataForm.source = data.users.source
                this.dataForm.idNumber = data.users.idNumber
                this.dataForm.collegeId = data.users.collegeId
                this.dataForm.preferences = data.users.preferences
                this.dataForm.createTime = data.users.createTime
                this.dataForm.createdUser = data.users.createdUser
                this.dataForm.updateTime = data.users.updateTime
                this.dataForm.updatedUser = data.users.updatedUser
                this.dataForm.isDelete = data.users.isDelete
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/user/users/${!this.dataForm.userId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'userId': this.dataForm.userId || undefined,
                'account': this.dataForm.account,
                'password': this.dataForm.password,
                'email': this.dataForm.email,
                'gender': this.dataForm.gender,
                'attributeId': this.dataForm.attributeId,
                'studentNumber': this.dataForm.studentNumber,
                'source': this.dataForm.source,
                'idNumber': this.dataForm.idNumber,
                'collegeId': this.dataForm.collegeId,
                'preferences': this.dataForm.preferences,
                'createTime': this.dataForm.createTime,
                'createdUser': this.dataForm.createdUser,
                'updateTime': this.dataForm.updateTime,
                'updatedUser': this.dataForm.updatedUser,
                'isDelete': this.dataForm.isDelete
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
